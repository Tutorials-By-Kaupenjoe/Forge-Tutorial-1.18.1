package net.kaupenjoe.tutorialmod.block.custom;

import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CucumberPlantBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public CucumberPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CUCUMBER_SEEDS.get();
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }
}
