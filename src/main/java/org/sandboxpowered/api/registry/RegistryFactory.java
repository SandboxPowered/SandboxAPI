package org.sandboxpowered.api.registry;

import org.sandboxpowered.api.Sandbox;

public interface RegistryFactory {
    static <T extends RegistryEntry<T>> Registry<T> getRegistry(Class<T> tClass) {
        return Sandbox.getFactoryProvider().provide(RegistryFactory.class).get(tClass);
    }

    <T extends RegistryEntry<T>> Registry<T> get(Class<T> tClass);
}
