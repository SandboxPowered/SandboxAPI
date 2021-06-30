package org.sandboxpowered.api.util.math;

import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.util.Direction;

public interface Position {

    static Position immutable(int x, int y, int z) {
        return Sandbox.getFactoryProvider().provide(PositionFactory.class).immutable(x, y, z);
    }

    static Position.Mutable mutable(int x, int y, int z) {
        return Sandbox.getFactoryProvider().provide(PositionFactory.class).mutable(x, y, z);
    }

    static Position.Mutable mutable() {
        return Sandbox.getFactoryProvider().provide(PositionFactory.class).mutable(0, 0, 0);
    }

    int getX();

    int getY();

    int getZ();

    Position shift(Direction direction);

    Position shift(Direction direction, int amount);

    Position add(Position position);

    Position add(int x, int y, int z);

    Position sub(Position position);

    Position sub(int x, int y, int z);

    Position toImmutable();

    Position.Mutable toMutable();

    interface Mutable extends Position {
        Position set(int x, int y, int z);
    }

    interface PositionFactory {
        Position immutable(int x, int y, int z);

        Position.Mutable mutable(int x, int y, int z);
    }
}