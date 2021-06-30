package org.sandboxpowered.api.world.state.property;

import com.google.common.collect.ImmutableSet;

import java.util.Collection;
import java.util.Optional;

public class BooleanProperty extends AbstractProperty<Boolean> {
    private final ImmutableSet<Boolean> values = ImmutableSet.of(true, false);

    protected BooleanProperty(String name) {
        super(name, Boolean.class);
    }

    public static BooleanProperty of(String string) {
        return new BooleanProperty(string);
    }

    @Override
    public String getValueString(Boolean value) {
        return value.toString();
    }

    @Override
    public Collection<Boolean> getValues() {
        return values;
    }

    @Override
    public Optional<Boolean> getValue(String string) {
        return !"true".equals(string) && !"false".equals(string) ? Optional.empty() : Optional.of(Boolean.valueOf(string));
    }
}