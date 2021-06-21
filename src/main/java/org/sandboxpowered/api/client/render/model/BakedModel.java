package org.sandboxpowered.api.client.render.model;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.client.render.mesh.Mesh;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.state.BlockState;

import java.util.Random;

public interface BakedModel {
    Mesh getMesh(BlockState state, Position position, @Nullable Direction direction, Random random);
}
