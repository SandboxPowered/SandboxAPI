package org.sandboxpowered.api.util;

import java.util.Locale;

public enum StairShape implements StringSerializable {
    STRAIGHT,
    INNER_LEFT,
    INNER_RIGHT,
    OUTER_LEFT,
    OUTER_RIGHT;

    @Override
    public String value() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
