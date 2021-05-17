package org.sandboxpowered.api.client.render;

import org.jetbrains.annotations.Nullable;

public interface RenderManager {
    @Nullable
    Renderer getRenderer();

    void registerRenderer(Renderer renderer);

    boolean isRendererAccessible();
}
