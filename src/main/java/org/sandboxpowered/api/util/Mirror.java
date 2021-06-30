package org.sandboxpowered.api.util;

import java.util.Locale;

public enum Mirror implements StringSerializable {
    /**
     * No Mirror
     */
    NONE,

    /**
     * Left/Right Mirror
     */
    X,

    /**
     * Front/Back Mirror
     */
    Z;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
