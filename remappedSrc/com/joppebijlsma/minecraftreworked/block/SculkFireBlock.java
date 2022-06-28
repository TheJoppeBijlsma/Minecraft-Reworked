package com.joppebijlsma.minecraftreworked.block;

import com.joppebijlsma.minecraftreworked.util.ModTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class SculkFireBlock extends AbstractFireBlock {
    public SculkFireBlock(AbstractBlock.Settings settings) {
        super(settings, 2.0F);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return isSculkBase(world.getBlockState(pos.down()));
    }

    public static boolean isSculkBase(BlockState state) {
        return state.isIn(ModTags.Blocks.SCULK_FIRE_BASE_BLOCKS);
    }

    protected boolean isFlammable(BlockState state) {
        return true;
    }
}
