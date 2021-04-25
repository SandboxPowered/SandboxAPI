package org.sandboxpowered.api.util;

public interface Identifier extends Comparable<Identifier> {
    String getNamespace();

    String getPath();

    interface Variant extends Identifier {
        String getVariant();
    }
}
