package org.sandboxpowered.api.entity;

public interface Entity {
    int getId();

    boolean hasComponent(Class<? extends Component> type);

    <T extends Component> T getComponent(Class<T> type);
}
