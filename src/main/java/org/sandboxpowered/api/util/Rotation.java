package org.sandboxpowered.api.util;

public enum Rotation {
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
    NEGATIVE
}
