package org.sandboxpowered.api.registry;

import org.sandboxpowered.api.util.Identifier;

public interface RegistryEntry<T extends RegistryEntry<T>> {
    @SuppressWarnings("unchecked")
    default Identifier getIdentifier() {
        return getRegistry().getId((T) this);
    }

    Registry<T> getRegistry();
}
