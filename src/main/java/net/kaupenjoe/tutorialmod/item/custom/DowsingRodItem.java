package net.kaupenjoe.tutorialmod.item.custom;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.kaupenjoe.tutorialmod.item.ModItems;
import net.kaupenjoe.tutorialmod.particle.ModParticles;
import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.kaupenjoe.tutorialmod.util.InventoryUtil;
import net.kaupenjoe.tutorialmod.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class DowsingRodItem extends Item {
	public DowsingRodItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		if (pContext.getLevel().isClientSide()) {
			BlockPos positionClicked = pContext.getClickedPos();
			Player player = pContext.getPlayer();
			boolean foundBlock = false;

			for (int i = 0; i <= positionClicked.getY() + 64; i++) {
				BlockState blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i));

				if (isValuableBlock(blockBelow)) {
					outputValuableCoordinates(positionClicked.below(i), player, blockBelow.getBlock());
					foundBlock = true;

					if (InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET.get())) {
						addNbtToDataTablet(player, positionClicked.below(i), blockBelow.getBlock());
					}

					spawnFoundParticles(pContext, positionClicked);

					pContext.getLevel().playSound(player, positionClicked, ModSounds.DOWSING_ROD_FOUND_ORE.get(),
							SoundSource.BLOCKS, 1f, 1f);

					break;
				}
			}

			if (!foundBlock) {
				player.sendSystemMessage(Component.translatable("item.tutorialmod.dowsing_rod.no_valuables"));
			}
		}

		pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
				(player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

		return super.useOn(pContext);
	}

	private void spawnFoundParticles(UseOnContext pContext, BlockPos positionClicked) {
		for (int i = 0; i < 360; i++) {
			if (i % 20 == 0) {
				pContext.getLevel().addParticle(ModParticles.CITRINE_PARTICLES.get(), positionClicked.getX() + 0.5d,
						positionClicked.getY() + 1, positionClicked.getZ() + 0.5d, Math.cos(i) * 0.15d, 0.15d,
						Math.sin(i) * 0.15d);
			}
		}
	}

	private void addNbtToDataTablet(Player player, BlockPos pos, Block blockBelow) {
		ItemStack dataTablet = player.getInventory()
				.getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET.get()));

		CompoundTag nbtData = new CompoundTag();
		nbtData.putString("tutorialmod.last_ore",
				"Found " + ForgeRegistries.ITEMS.getKey(blockBelow.asItem()).toString() + " at (" + pos.getX() + ", "
						+ pos.getY() + ", " + pos.getZ() + ")");

		dataTablet.setTag(nbtData);
	}

	@Override
	public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
			TooltipFlag pIsAdvanced) {
		if (Screen.hasShiftDown()) {
			pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.dowsing_rod.tooltip.shift"));
		} else {
			pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.dowsing_rod.tooltip"));
		}
	}

	private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
		player.sendSystemMessage(
				Component.literal("Found " + ForgeRegistries.ITEMS.getKey(blockBelow.asItem()).toString() + " at " + "("
						+ blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"));
	}

	private boolean isValuableBlock(BlockState state) {
		return state.is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
	}
}
