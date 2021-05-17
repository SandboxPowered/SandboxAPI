package org.sandboxpowered.api.client.render;

import org.sandboxpowered.api.client.render.material.RenderMaterial;
import org.sandboxpowered.api.client.render.model.BakedModel;
import org.sandboxpowered.api.util.Identifier;
import org.sandboxpowered.api.world.state.BlockState;

public interface Renderer {
    Identifier getId();

    BakedModel getBlockModel(BlockState state);

    RenderMaterial getRenderMaterial(Identifier id);

    boolean registerRenderMaterial(Identifier id, RenderMaterial material);
}
