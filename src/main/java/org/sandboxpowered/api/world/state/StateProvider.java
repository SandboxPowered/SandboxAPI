package org.sandboxpowered.api.world.state;

import org.sandboxpowered.api.registry.RegistryEntry;

import java.util.Collection;

public interface StateProvider<T extends RegistryEntry<T>, S extends PropertyContainer<S>> {
    Collection<S> getValidStates();

    T getBaseObject();

    S getBaseState();

    interface Builder<T extends RegistryEntry<T>, S extends PropertyContainer<S>> {
        StateProvider.Builder<T, S> add(Property<?>... properties);
    }

    interface StateFactory {
        <T extends RegistryEntry<T>, S extends PropertyContainer<S>, E extends T> Builder<T, S> createBuilder(E object);

        <T extends RegistryEntry<T>, S extends PropertyContainer<S>, E extends T> StateProvider<T, S> create(Builder<T, S> builder);
    }
}
