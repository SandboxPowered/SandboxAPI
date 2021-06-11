package org.sandboxpowered.api.entity;

import org.sandboxpowered.api.world.World;

public interface Entity {
    int getId();

    World getWorld();

    boolean hasComponent(Class<? extends Component> type);

    <T extends Component> T getComponent(Class<T> type);
}
