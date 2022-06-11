package net.kaupenjoe.tutorialmod.datagen.loot;

import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.block.custom.CucumberPlantBlock;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[] { 0.05F, 0.0625F, 0.083333336F, 0.1F };

    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.CITRINE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_CITRINE_BLOCK.get());

        this.add(ModBlocks.CITRINE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.CITRINE_ORE.get(), ModItems.RAW_CITRINE.get()));
        this.add(ModBlocks.DEEPSLATE_CITRINE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_CITRINE_ORE.get(), ModItems.RAW_CITRINE.get()));
        this.add(ModBlocks.NETHERRACK_CITRINE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHERRACK_CITRINE_ORE.get(), ModItems.RAW_CITRINE.get()));
        this.add(ModBlocks.ENDSTONE_CITRINE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.ENDSTONE_CITRINE_ORE.get(), ModItems.RAW_CITRINE.get()));


        this.dropSelf(ModBlocks.SPEEDY_BLOCK.get());
        this.dropSelf(ModBlocks.CITRINE_STAIRS.get());

        this.add(ModBlocks.CITRINE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.CITRINE_FENCE.get());
        this.dropSelf(ModBlocks.CITRINE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.CITRINE_WALL.get());

        this.add(ModBlocks.EBONY_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.POTTED_PINK_ROSE.get(), BlockLoot::createPotFlowerItemTable);

        this.dropSelf(ModBlocks.CITRINE_BUTTON.get());
        this.dropSelf(ModBlocks.CITRINE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.EBONY_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PINK_ROSE.get());

        this.dropWhenSilkTouch(ModBlocks.WINTER_WINDOW.get());

        this.dropSelf(ModBlocks.CITRINE_LAMP.get());

        this.dropSelf(ModBlocks.EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_WOOD.get());
        this.dropSelf(ModBlocks.EBONY_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());

        this.add(ModBlocks.EBONY_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.EBONY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.EBONY_SAPLING.get());
        this.dropSelf(ModBlocks.GEM_CUTTING_STATION.get());

        this.dropOther(ModBlocks.EBONY_WALL_SIGN.get(), ModItems.EBONY_SIGN.get());
        this.dropOther(ModBlocks.EBONY_SIGN.get(), ModItems.EBONY_SIGN.get());

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CUCUMBER_PLANT.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CucumberPlantBlock.AGE, 5));

        this.add(ModBlocks.CUCUMBER_PLANT.get(), createCropDrops(ModBlocks.CUCUMBER_PLANT.get(), ModItems.CUCUMBER.get(),
                ModItems.CUCUMBER_SEEDS.get(), lootitemcondition$builder));

        this.dropSelf(ModBlocks.ANIMATED_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
