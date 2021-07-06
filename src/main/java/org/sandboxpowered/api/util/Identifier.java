package org.sandboxpowered.api.util;

import org.sandboxpowered.api.engine.Sandbox;

public interface Identifier extends Comparable<Identifier> {
    static Identifier of(String id) {
        return Sandbox.getFactoryProvider().provide(IdentifierFactory.class).create(id);
    }

    static Identifier of(String namespace, String path) {
        return Sandbox.getFactoryProvider().provide(IdentifierFactory.class).create(namespace, path);
    }

    String getNamespace();

    String getPath();

    interface Variant extends Identifier {
        String getVariant();
    }

    interface IdentifierFactory {
        Identifier create(String namespace, String path);

        Identifier create(String id);
    }
}
