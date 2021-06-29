package org.sandboxpowered.api.item.attribute;

import org.sandboxpowered.api.Sandbox;

import java.util.UUID;

public interface Attribute {

    static Modifier modifier(UUID uuid, String name, double value, Operation operation) {
        return Sandbox.getFactoryProvider().provide(ModifierFactory.class).create(uuid, name, value, operation);
    }

    interface Modifier {
    }

    interface ModifierFactory {
        Modifier create(UUID attribute, String name, double value, Operation operation);
    }

    enum Operation {
        ADDITION,
        MULTIPLY_BASE,
        MULTIPLY_TOTAL
    }
}
