package org.sandboxpowered.api.world;

import org.sandboxpowered.api.content.block.MultipartSlot;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.state.BlockState;
import org.sandboxpowered.api.world.state.FluidState;

import java.util.Collection;

public interface WorldReader {
    BlockState getBlockState(Position pos, MultipartSlot slot);

    Collection<BlockState> getBlockStates(Position pos);

    BlockState getBlockState(Position pos);

    FluidState getFluidState(Position pos);
}
