package net.kaupenjoe.tutorialmod.world.feature;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final PlacedFeature EBONY_PLACED = PlacementUtils.register("ebony_placed",
                    ModConfiguredFeature.EBONY_TREE_CHECKED.placed(VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(3, 0.1f, 2))));
}
