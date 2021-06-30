package org.sandboxpowered.api.util;

import java.util.Locale;

public enum Half implements StringSerializable {
    TOP,
    BOTTOM;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}