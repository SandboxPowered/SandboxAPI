package org.sandboxpowered.api.world;

import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.state.BlockState;
import org.sandboxpowered.api.world.state.FluidState;

public interface WorldReader {
    BlockState getBlockState(Position pos);

    FluidState getFluidState(Position pos);
}
