package org.sandboxpowered.api.addon;

import org.sandboxpowered.api.registry.DeferredRegistrar;
import org.sandboxpowered.api.registry.RegistryEntry;

import java.util.Optional;

public interface SandboxAPI {
    <T extends RegistryEntry<T>> DeferredRegistrar<T> registrar(Class<T> tClass);

    <T extends CreationService> Optional<T> getCreationService(Class<T> tClass);
}
