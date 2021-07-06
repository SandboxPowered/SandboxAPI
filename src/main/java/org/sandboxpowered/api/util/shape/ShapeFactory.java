package org.sandboxpowered.api.util.shape;

public interface ShapeFactory {
    Shape createCuboid(int x1, int y1, int z1, int x2, int y2, int z2);

    Shape fullCube();
}
