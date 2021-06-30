package org.sandboxpowered.api.util;

import java.util.Locale;

public enum BedHalf implements StringSerializable {
    HEAD,
    FOOT;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
