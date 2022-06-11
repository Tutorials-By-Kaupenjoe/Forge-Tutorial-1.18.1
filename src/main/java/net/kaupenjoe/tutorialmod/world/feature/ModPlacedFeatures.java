package net.kaupenjoe.tutorialmod.world.feature;

import java.util.List;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.config.TutorialModCommonConfigs;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {
	public static final DeferredRegister<PlacedFeature> FEATURES = DeferredRegister
			.create(Registry.PLACED_FEATURE_REGISTRY, TutorialMod.MOD_ID);

	public static final RegistryObject<PlacedFeature> EBONY_PLACED = FEATURES.register("ebony_placed",
			() -> new PlacedFeature(ModConfiguredFeatures.EBONY_SPAWN.getHolder().get(),
					VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2))));

	public static final RegistryObject<PlacedFeature> PINK_ROSE_PLACED = FEATURES.register("pink_rose_placed",
			() -> new PlacedFeature(ModConfiguredFeatures.PINK_ROSE.getHolder().get(),
					List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
							BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> CITRINE_ORE_PLACED = FEATURES.register("citrine_ore_placed",
			() -> new PlacedFeature(ModConfiguredFeatures.CITRINE_ORE.getHolder().get(),
					ModOrePlacement.commonOrePlacement(TutorialModCommonConfigs.CITRINE_ORE_VEINS_PER_CHUNK.get(), // VeinsPerChunk
							HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80),
									VerticalAnchor.aboveBottom(80)))));

	public static final RegistryObject<PlacedFeature> END_CITRINE_ORE_PLACED = FEATURES.register(
			"end_citrine_ore_placed",
			() -> new PlacedFeature(ModConfiguredFeatures.END_CITRINE_ORE.getHolder().get(),
					ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
							HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80),
									VerticalAnchor.aboveBottom(80)))));

	public static final RegistryObject<PlacedFeature> NETHER_CITRINE_ORE_PLACED = FEATURES.register("nether_citrine_ore_placed",
			() -> new PlacedFeature(ModConfiguredFeatures.NETHER_CITRINE_ORE.getHolder().get(),
					ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
							HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80),
									VerticalAnchor.aboveBottom(80)))));

}
