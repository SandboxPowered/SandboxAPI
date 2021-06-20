package org.sandboxpowered.api.entity.component;

import org.joml.Vector3f;
import org.joml.Vector3fc;

public class PositionComponent implements PooledComponent {
    private Vector3f pos;

    public Vector3fc getPos() {
        return pos;
    }

    @Override
    public void reset() {
        this.pos.set(0);
    }
}
