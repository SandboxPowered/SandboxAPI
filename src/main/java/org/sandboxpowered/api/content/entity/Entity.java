package org.sandboxpowered.api.content.entity;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.content.entity.component.Component;
import org.sandboxpowered.api.world.World;

public interface Entity {
    int getId();

    World getWorld();

    boolean hasComponent(Class<? extends Component> type);

    @Nullable <T extends Component> T getComponent(Class<T> type);
}
