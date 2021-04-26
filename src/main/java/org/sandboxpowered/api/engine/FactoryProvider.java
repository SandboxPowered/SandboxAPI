package org.sandboxpowered.api.engine;

public interface FactoryProvider {
    <T> T provide(Class<T> clazz);
}
