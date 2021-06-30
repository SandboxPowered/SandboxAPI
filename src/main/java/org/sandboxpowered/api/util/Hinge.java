package org.sandboxpowered.api.util;

import java.util.Locale;

public enum Hinge implements StringSerializable {
    LEFT,
    RIGHT;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
