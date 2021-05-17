package org.sandboxpowered.api.client.render.model;

import org.joml.Vector3ic;
import org.sandboxpowered.api.client.render.RenderContext;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.world.WorldReader;
import org.sandboxpowered.api.world.state.BlockState;

import java.util.Random;
import java.util.function.Supplier;

public interface DynamicBakedModel extends BakedModel {
    void emitMesh(WorldReader reader, BlockState state, Vector3ic position, Supplier<Random> randomSupplier, RenderContext context);

    void emitItemMesh(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context);
}
