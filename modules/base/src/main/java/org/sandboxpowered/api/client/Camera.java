package org.sandboxpowered.api.client;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.util.math.Quaternion;
import org.sandboxpowered.api.util.math.Vec3d;

public interface Camera {

    Projection getProjection();

    Entity getTargetEntity();

    Vec3d getPosition();

    Quaternion getRotation();

    enum Projection {
        PERSPECTIVE,
        ORTHOGRAPHIC
    }
}
