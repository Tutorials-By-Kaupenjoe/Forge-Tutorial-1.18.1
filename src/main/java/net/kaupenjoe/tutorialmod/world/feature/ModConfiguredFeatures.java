package net.kaupenjoe.tutorialmod.world.feature;

import java.util.List;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.config.TutorialModCommonConfigs;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {
	public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister
			.create(Registry.CONFIGURED_FEATURE_REGISTRY, TutorialMod.MOD_ID);

	public static final RegistryObject<ConfiguredFeature<?, ?>> EBONY_TREE = FEATURES.register("ebony",
			() -> new ConfiguredFeature<>(Feature.TREE,
					new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
							new StraightTrunkPlacer(5, 6, 3), BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
							new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
							new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.END_STONE))
							.build()));

	public static final RegistryObject<PlacedFeature> EBONY_CHECKED = ModPlacedFeatures.FEATURES
			.register("ebony_checked", () -> new PlacedFeature(EBONY_TREE.getHolder().get(),
					List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.EBONY_SAPLING.get()))));

	public static final RegistryObject<ConfiguredFeature<?, ?>> EBONY_SPAWN = FEATURES.register("ebony_spawn",
			() -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
					new RandomFeatureConfiguration(
							List.of(new WeightedPlacedFeature(EBONY_CHECKED.getHolder().get(), 0.5F)),
							EBONY_CHECKED.getHolder().get())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_ROSE = FEATURES.register("flower_pink_rose",
			() -> new ConfiguredFeature<>(Feature.FLOWER,
					new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
							new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINK_ROSE.get()))))));

	public static final List<OreConfiguration.TargetBlockState> OVERWORLD_CITRINE_ORES = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
					ModBlocks.CITRINE_ORE.get().defaultBlockState()),
			OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
					ModBlocks.DEEPSLATE_CITRINE_ORE.get().defaultBlockState()));

	public static final List<OreConfiguration.TargetBlockState> END_CITRINE_ORES = List.of(OreConfiguration
			.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_CITRINE_ORE.get().defaultBlockState()));

	public static final List<OreConfiguration.TargetBlockState> NETHER_CITRINE_ORES = List.of(OreConfiguration
			.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_CITRINE_ORE.get().defaultBlockState()));

	public static final RegistryObject<ConfiguredFeature<?, ?>> CITRINE_ORE = FEATURES.register("citrine_ore",
			() -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_CITRINE_ORES,
					TutorialModCommonConfigs.CITRINE_ORE_VEIN_SIZE.get())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> END_CITRINE_ORE = FEATURES.register("end_citrine_ore",
			() -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_CITRINE_ORES, 9)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_CITRINE_ORE = FEATURES
			.register("nether_citrine_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_CITRINE_ORES, 9)));

}
