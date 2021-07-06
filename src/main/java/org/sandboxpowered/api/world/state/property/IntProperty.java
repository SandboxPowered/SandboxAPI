package org.sandboxpowered.api.world.state.property;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.jetbrains.annotations.Range;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class IntProperty extends AbstractProperty<Integer> {
    private final ImmutableSet<Integer> values;

    private IntProperty(String name, int min, int max) {
        super(name, Integer.class);
        if (min < 0) {
            throw new IllegalArgumentException("Min value of " + name + " must be 0 or greater");
        } else if (max <= min) {
            throw new IllegalArgumentException("Max value of " + name + " must be greater than min (" + min + ")");
        }
        Set<Integer> set = Sets.newHashSet();
        for (int val = min; val <= max; ++val) {
            set.add(val);
        }
        this.values = ImmutableSet.copyOf(set);
    }

    public static IntProperty of(String name, int min, int max) {
        return new IntProperty(name, min, max);
    }

    @Override
    public String getValueString(Integer value) {
        return value.toString();
    }

    @Override
    public Collection<Integer> getValues() {
        return values;
    }

    @Override
    public Optional<Integer> getValue(String name) {
        Integer i = Integer.valueOf(name);
        if (values.contains(i)) {
            return Optional.of(i);
        } else {
            return Optional.empty();
        }
    }
}