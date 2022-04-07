package net.kaupenjoe.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.PlantType;

import java.util.function.Supplier;

public class ModSaplingBlock extends SaplingBlock {
    private Supplier<Block> otherDirt;

    public ModSaplingBlock(AbstractTreeGrower pTreeGrower, Properties pProperties, Supplier<Block> otherDirt) {
        super(pTreeGrower, pProperties);
        this.otherDirt = otherDirt;
    }

    @Override
    public boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(otherDirt.get());
    }
}
