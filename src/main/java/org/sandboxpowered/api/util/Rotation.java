package org.sandboxpowered.api.util;

import java.util.Locale;

public enum Rotation implements StringSerializable {
    /**
     * No Rotation
     */
    NONE,

    /**
     * Clockwise +90 / Counter Clockwise -270
     */
    POSITIVE,

    /**
     * Clockwise +180 / Counter Clockwise -180
     */
    FLIP,

    /**
     * Clockwise +270 / Counter Clockwise -90
     */
    NEGATIVE;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
