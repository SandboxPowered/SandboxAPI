package org.sandboxpowered.api.world.state.property;

import java.util.Collection;
import java.util.Optional;

public interface Property<T extends Comparable<T>> {
    String getPropertyName();

    String getValueString(T value);

    Collection<T> getValues();

    Class<T> getValueType();

    Optional<T> getValue(String name);
}
