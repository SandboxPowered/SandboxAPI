package org.sandboxpowered.api.world;

import org.joml.Vector3ic;
import org.sandboxpowered.api.world.state.BlockState;
import org.sandboxpowered.api.world.state.FluidState;

public interface WorldReader {
    BlockState getBlockState(Vector3ic pos);

    FluidState getFluidState(Vector3ic pos);
}
