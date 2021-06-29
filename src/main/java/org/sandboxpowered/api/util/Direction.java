package org.sandboxpowered.api.util;

import java.util.Locale;

public enum Direction implements StringSerializable {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    UP,
    DOWN;

    @Override
    public String value() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
