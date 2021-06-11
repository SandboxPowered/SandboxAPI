package org.sandboxpowered.api.addon.service.resource;

import org.sandboxpowered.api.registry.RegistryEntry;

import java.util.Set;
import java.util.function.Supplier;

public interface Resource<C extends RegistryEntry<C>> extends Supplier<C> {
    Set<C> getVariants();

    ResourceMaterial getMaterial();

    ResourceType<C> getType();
}