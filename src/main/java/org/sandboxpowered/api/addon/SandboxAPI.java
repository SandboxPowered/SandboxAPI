package org.sandboxpowered.api.addon;

import org.sandboxpowered.api.addon.service.CreationService;
import org.sandboxpowered.api.registry.DeferredRegistrar;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.registry.RegistryEntry;

import java.util.Optional;
import java.util.function.Consumer;

public interface SandboxAPI {
    <T extends RegistryEntry<T>> DeferredRegistrar<T> getRegistrar(Registry<T> registry);

    <T extends CreationService> Optional<T> getCreationService(Class<T> tClass);

    <T extends CreationService> void useCreationService(Class<T> resourceServiceClass, Consumer<T> consumer);
}
