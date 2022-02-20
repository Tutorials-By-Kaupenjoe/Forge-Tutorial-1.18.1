package net.kaupenjoe.tutorialmod.world.feature.tree;

import net.kaupenjoe.tutorialmod.world.feature.ModConfiguredFeature;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class EbonyTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ConfiguredFeature<?, ?> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
        return ModConfiguredFeature.EBONY_TREE;
    }
}
