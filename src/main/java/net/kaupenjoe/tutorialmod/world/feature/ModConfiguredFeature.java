package net.kaupenjoe.tutorialmod.world.feature;

import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeature {
    public static final ConfiguredFeature<TreeConfiguration, ?> EBONY_TREE =
            FeatureUtils.register("ebony", Feature.TREE.configured(
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> EBONY_TREE_CHECKED =
            FeatureUtils.register("ebony_checked",
                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            EBONY_TREE.filteredByBlockSurvival(ModBlocks.EBONY_SAPLING.get()), 0.1f)),
                            EBONY_TREE.filteredByBlockSurvival(ModBlocks.EBONY_SAPLING.get()))));

    public static final ConfiguredFeature<RandomPatchConfiguration, ?> PINK_ROSE =
            FeatureUtils.register("flower_pink_rose", Feature.FLOWER.configured(
                    new RandomPatchConfiguration(32, 6, 2, () -> Feature.SIMPLE_BLOCK.configured(
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINK_ROSE.get()))).onlyWhenEmpty())));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_CITRINE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CITRINE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_CITRINE_ORE.get().defaultBlockState()));

    public static final ConfiguredFeature<?, ?> CITRINE_ORE = FeatureUtils.register("citrine_ore",
            Feature.ORE.configured(new OreConfiguration(OVERWORLD_CITRINE_ORES, 9)));

}
