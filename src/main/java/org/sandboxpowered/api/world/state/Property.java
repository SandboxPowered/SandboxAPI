package org.sandboxpowered.api.world.state;

import java.util.Collection;
import java.util.Optional;

public interface Property<T extends Comparable<T>> {
    String getPropertyName();

    String getValueString(String string);

    Collection<T> getValues();

    Class<T> getValueType();

    Optional<T> getValue(String name);
}
