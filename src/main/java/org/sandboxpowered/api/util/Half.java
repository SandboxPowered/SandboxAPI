package org.sandboxpowered.api.util;

import java.util.Locale;

public enum Half implements StringSerializable {
    TOP,
    BOTTOM;

    @Override
    public String value() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}