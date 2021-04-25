package org.sandboxpowered.api.registry;

import org.sandboxpowered.api.util.Identifier;

import java.util.function.Supplier;

public interface DeferredRegistrar<T extends RegistryEntry<T>> {
    RegistryObject<T> register(String name, Supplier<T> supplier);

    RegistryObject<T> register(Identifier id, Supplier<T> supplier);
}
