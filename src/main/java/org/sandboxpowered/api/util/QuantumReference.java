package org.sandboxpowered.api.util;

import org.jetbrains.annotations.Nullable;

public class QuantumReference<T> {
    private boolean stored;
    private T value;

    @Nullable
    public T get() {
        return value;
    }

    public boolean isStored() {
        return stored;
    }

    public void store(T value) {
        this.value = value;
        this.stored = true;
    }

    public void clear() {
        this.value = null;
        this.stored = false;
    }
}