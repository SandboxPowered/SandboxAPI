package org.sandboxpowered.api.world.state;

import org.sandboxpowered.api.world.state.property.Property;

public interface PropertyContainer<S> {
    <T extends Comparable<T>> T get(Property<T> property);

    <T extends Comparable<T>> S with(Property<T> property, T value);

    <T extends Comparable<T>> S cycle(Property<T> property);

    <T extends Comparable<T>> boolean has(Property<T> property);
}
