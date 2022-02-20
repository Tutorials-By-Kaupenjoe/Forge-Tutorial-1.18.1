package net.kaupenjoe.tutorialmod.world.feature;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures {
    public static final PlacedFeature EBONY_PLACED = PlacementUtils.register("ebony_placed",
                    ModConfiguredFeature.EBONY_TREE_CHECKED.placed(VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(3, 0.1f, 2))));

    public static final PlacedFeature PINK_ROSE_PLACED = PlacementUtils.register("pink_rose_placed",
            ModConfiguredFeature.PINK_ROSE.placed(RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    public static final PlacedFeature CITRINE_ORE_PLACED = PlacementUtils.register("citrine_ore_placed",
            ModConfiguredFeature.CITRINE_ORE.placed(ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

}
