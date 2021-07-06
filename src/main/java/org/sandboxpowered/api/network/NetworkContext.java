package org.sandboxpowered.api.network;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.content.entity.Entity;

public interface NetworkContext {
    @Nullable
    Entity getSender();
}
