package org.sandboxpowered.api.util;

import java.util.Locale;

public enum BedHalf implements StringSerializable {
    HEAD,
    FOOT;

    @Override
    public String value() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
