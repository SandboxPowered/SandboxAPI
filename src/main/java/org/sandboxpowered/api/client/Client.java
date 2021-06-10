package org.sandboxpowered.api.client;

import org.sandboxpowered.api.client.render.RenderManager;
import org.sandboxpowered.api.client.resource.ResourceManager;
import org.sandboxpowered.api.engine.Engine;

public interface Client extends Engine {
    RenderManager getRenderManager();

    ResourceManager getResourceManager();
}
