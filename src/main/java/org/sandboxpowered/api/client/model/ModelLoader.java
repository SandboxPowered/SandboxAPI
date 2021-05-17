package org.sandboxpowered.api.client.model;

import com.google.gson.JsonObject;
import org.sandboxpowered.api.client.render.mesh.Mesh;
import org.sandboxpowered.api.client.resource.ResourceManager;
import org.sandboxpowered.api.util.Identifier;

public interface ModelLoader {
    Identifier getId();

    Mesh load(Identifier model, ResourceManager manager, JsonObject json);
}
