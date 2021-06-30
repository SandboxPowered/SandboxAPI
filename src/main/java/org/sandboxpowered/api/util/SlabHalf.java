package org.sandboxpowered.api.util;

import java.util.Locale;

public enum SlabHalf implements StringSerializable {
    TOP,
    BOTTOM,
    DOUBLE;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
