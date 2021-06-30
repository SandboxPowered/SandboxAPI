package org.sandboxpowered.api.util;

import java.util.Locale;

public enum Hinge implements StringSerializable {
    LEFT,
    RIGHT;

    @Override
    public String value() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
