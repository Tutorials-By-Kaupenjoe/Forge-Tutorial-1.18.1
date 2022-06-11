package net.kaupenjoe.tutorialmod.world.feature.tree;

import org.jetbrains.annotations.Nullable;

import net.kaupenjoe.tutorialmod.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class EbonyTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_204307_, boolean p_204308_) {
        return ModConfiguredFeatures.EBONY_TREE;
    }
}
