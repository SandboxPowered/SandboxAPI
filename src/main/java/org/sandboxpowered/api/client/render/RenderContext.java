package org.sandboxpowered.api.client.render;

import org.sandboxpowered.api.client.render.mesh.Mesh;
import org.sandboxpowered.api.client.render.model.BakedModel;

public interface RenderContext {
    void consume(BakedModel model);

    void consume(Mesh mesh);
}
