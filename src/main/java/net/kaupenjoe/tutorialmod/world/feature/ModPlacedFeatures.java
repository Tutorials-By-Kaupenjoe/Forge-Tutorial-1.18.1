package net.kaupenjoe.tutorialmod.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> EBONY_PLACED = PlacementUtils.register("ebony_placed",
            ModConfiguredFeatures.EBONY_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2)));

    public static final Holder<PlacedFeature> PINK_ROSE_PLACED = PlacementUtils.register("pink_rose_placed",
            ModConfiguredFeatures.PINK_ROSE, RarityFilter.onAverageOnceEvery(16),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
}
