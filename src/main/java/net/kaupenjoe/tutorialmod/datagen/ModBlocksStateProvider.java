package net.kaupenjoe.tutorialmod.datagen;

import java.util.function.Function;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.block.custom.CucumberPlantBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.CITRINE_BLOCK.get());
        simpleBlock(ModBlocks.RAW_CITRINE_BLOCK.get());
        simpleBlock(ModBlocks.CITRINE_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_CITRINE_ORE.get());
        simpleBlock(ModBlocks.NETHERRACK_CITRINE_ORE.get());
        simpleBlock(ModBlocks.ENDSTONE_CITRINE_ORE.get());
        simpleBlock(ModBlocks.SPEEDY_BLOCK.get());

        buttonBlock((ButtonBlock)ModBlocks.CITRINE_BUTTON.get(), blockTexture(ModBlocks.CITRINE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock)ModBlocks.CITRINE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CITRINE_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.CITRINE_WALL.get(), blockTexture(ModBlocks.CITRINE_BLOCK.get()));
        fenceBlock((FenceBlock) ModBlocks.CITRINE_FENCE.get(), blockTexture(ModBlocks.CITRINE_BLOCK.get()));

        fenceGateBlock((FenceGateBlock) ModBlocks.CITRINE_FENCE_GATE.get(), blockTexture(ModBlocks.CITRINE_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.CITRINE_SLAB.get(), blockTexture(ModBlocks.CITRINE_BLOCK.get()),
                blockTexture(ModBlocks.CITRINE_BLOCK.get()));
        stairsBlock((StairBlock) ModBlocks.CITRINE_STAIRS.get(), blockTexture(ModBlocks.CITRINE_BLOCK.get()));

        doorBlock((DoorBlock) ModBlocks.EBONY_DOOR.get(), new ResourceLocation(TutorialMod.MOD_ID, "block/ebony_door_bottom"),
                new ResourceLocation(TutorialMod.MOD_ID, "block/ebony_door_top"));
        trapdoorBlock((TrapDoorBlock) ModBlocks.EBONY_TRAPDOOR.get(), blockTexture(ModBlocks.EBONY_TRAPDOOR.get()), true);

        logBlock((RotatedPillarBlock) ModBlocks.EBONY_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.EBONY_WOOD.get(), blockTexture(ModBlocks.EBONY_LOG.get()), blockTexture(ModBlocks.EBONY_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_LOG.get(), new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_log"),
                new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_WOOD.get(), new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_log"),
                new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_top"));

        simpleBlock(ModBlocks.EBONY_PLANKS.get());
        simpleBlock(ModBlocks.EBONY_LEAVES.get());
        simpleBlock(ModBlocks.WINTER_WINDOW.get());

        signBlock((StandingSignBlock)ModBlocks.EBONY_SIGN.get(), (WallSignBlock)ModBlocks.EBONY_WALL_SIGN.get(),
                blockTexture(ModBlocks.EBONY_PLANKS.get()));

        simpleBlock(ModBlocks.PINK_ROSE.get(), models().cross(ForgeRegistries.BLOCKS.getKey(ModBlocks.PINK_ROSE.get()).getPath(),
                blockTexture(ModBlocks.PINK_ROSE.get())));
        simpleBlock(ModBlocks.EBONY_SAPLING.get(), models().cross(ForgeRegistries.BLOCKS.getKey(ModBlocks.EBONY_SAPLING.get()).getPath(),
                blockTexture(ModBlocks.EBONY_SAPLING.get())));

        simpleBlock(ModBlocks.POTTED_PINK_ROSE.get(), flowerPotCross(ForgeRegistries.BLOCKS.getKey(ModBlocks.POTTED_PINK_ROSE.get()).getPath()));

        makeCrop((CucumberPlantBlock)ModBlocks.CUCUMBER_PLANT.get(), "cucumber_stage", "cucumber_stage");
    }

    public ModelFile flowerPotCross(String name) {
        return models().withExistingParent(name, "flower_pot_cross");
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(block.getAgeProperty()),
                new ResourceLocation(TutorialMod.MOD_ID, "block/" + textureName + state.getValue(block.getAgeProperty()))));

        return models;
    }
}
