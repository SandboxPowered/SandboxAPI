package org.sandboxpowered.api.registry;

import org.sandboxpowered.api.util.Identifier;

public interface RegistryEntry<T extends RegistryEntry<T>> {
    Identifier getIdentifier();

    Class<T> getRegistryType();
}
