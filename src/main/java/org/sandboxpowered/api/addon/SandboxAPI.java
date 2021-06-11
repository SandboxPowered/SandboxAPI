package org.sandboxpowered.api.addon;

import org.sandboxpowered.api.addon.service.CreationService;
import org.sandboxpowered.api.registry.DeferredRegistrar;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.registry.RegistryEntry;

import java.util.Optional;

public interface SandboxAPI {
    <T extends RegistryEntry<T>> DeferredRegistrar<T> getRegistrar(Registry<T> registry);

    <T extends CreationService> Optional<T> getCreationService(Class<T> tClass);
}
