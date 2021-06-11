package org.sandboxpowered.api.addon.service.resource;

import org.sandboxpowered.api.addon.service.CreationService;
import org.sandboxpowered.api.registry.RegistryEntry;

import java.util.function.Supplier;

public interface ResourceService extends CreationService {
    void add(ResourceMaterial material, ResourceType<?>... types);

    <C extends RegistryEntry<C>> void add(ResourceMaterial material, ResourceType<C> type);

    <C extends RegistryEntry<C>> void add(ResourceMaterial material, ResourceType<C> type, Supplier<C> supplier);

    <C extends RegistryEntry<C>> void add(ResourceMaterial material, ResourceType<C> type, C content);

    <C extends RegistryEntry<C>> boolean contains(ResourceMaterial material, ResourceType<C> type);
}
