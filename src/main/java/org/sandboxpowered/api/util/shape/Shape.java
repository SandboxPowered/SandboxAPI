package org.sandboxpowered.api.util.shape;

import org.sandboxpowered.api.engine.Sandbox;

public interface Shape {
    static Shape fullCube() {
        return Sandbox.getFactoryProvider().provide(ShapeFactory.class).fullCube();
    }

    static Shape createCuboid(int x1, int y1, int z1, int x2, int y2, int z2) {
        return Sandbox.getFactoryProvider().provide(ShapeFactory.class).createCuboid(x1, y1, z1, x2, y2, z2);
    }

    Shape combine(Shape other, ShapeCombination combiner);
}
