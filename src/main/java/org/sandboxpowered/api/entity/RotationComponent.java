package org.sandboxpowered.api.entity;

import org.joml.Quaternionf;
import org.joml.Quaternionfc;

public class RotationComponent implements PooledComponent {
    private Quaternionf rotation;

    public Quaternionfc getRotation() {
        return rotation;
    }

    @Override
    public void reset() {
        this.rotation.set(0, 0, 0, 0);
    }

}
