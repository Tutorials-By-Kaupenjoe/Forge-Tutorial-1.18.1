package net.kaupenjoe.tutorialmod;

import com.mojang.logging.LogUtils;

import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.block.entity.ModBlockEntities;
import net.kaupenjoe.tutorialmod.block.entity.ModWoodTypes;
import net.kaupenjoe.tutorialmod.config.TutorialModClientConfigs;
import net.kaupenjoe.tutorialmod.config.TutorialModCommonConfigs;
import net.kaupenjoe.tutorialmod.effect.ModEffects;
import net.kaupenjoe.tutorialmod.enchantment.ModEnchantments;
import net.kaupenjoe.tutorialmod.entity.ModEntityTypes;
import net.kaupenjoe.tutorialmod.fluid.ModFluids;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.kaupenjoe.tutorialmod.loot_modifiers.ModLootModifiers;
import net.kaupenjoe.tutorialmod.painting.ModPaintings;
import net.kaupenjoe.tutorialmod.particle.ModParticles;
import net.kaupenjoe.tutorialmod.potion.ModPotions;
import net.kaupenjoe.tutorialmod.recipe.ModRecipes;
import net.kaupenjoe.tutorialmod.screen.ModMenuTypes;
import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.kaupenjoe.tutorialmod.util.BetterBrewingRecipe;
import net.kaupenjoe.tutorialmod.villager.ModPOIs;
import net.kaupenjoe.tutorialmod.villager.ModVillagers;
import net.kaupenjoe.tutorialmod.world.dimension.ModDimensions;
import net.kaupenjoe.tutorialmod.world.gen.biome_modifiers.ModBiomeModifiers;
import net.kaupenjoe.tutorialmod.world.structure.ModStructures;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";

    // Directly reference a slf4j logger.
    public static final org.slf4j.Logger LOGGER = LogUtils.getLogger();

    // Add a comment
    public TutorialMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModPaintings.register(eventBus);
        ModSounds.register(eventBus);

        ModEffects.register(eventBus);
        ModPotions.register(eventBus);

        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);

        ModRecipes.register(eventBus);
        ModParticles.register(eventBus);

        ModFluids.register(eventBus);
        ModEnchantments.register(eventBus);

        ModEntityTypes.register(eventBus);
        ModVillagers.register(eventBus);

        ModStructures.register(eventBus);
        ModDimensions.register();

        ModPOIs.register(eventBus);
        ModLootModifiers.register(eventBus);
        
        ModBiomeModifiers.register(eventBus);

        eventBus.addListener(this::setup);

        GeckoLib.initialize();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, TutorialModClientConfigs.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TutorialModCommonConfigs.SPEC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    ModItems.CITRINE.get(), ModPotions.FREEZE_POTION.get()));

            Sheets.addWoodType(ModWoodTypes.EBONY);

            SpawnPlacements.register(ModEntityTypes.RACCOON.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);

            ModVillagers.registerPOIs();
        });
    }
}
