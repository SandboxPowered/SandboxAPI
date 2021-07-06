package org.sandboxpowered.api.event;

import org.sandboxpowered.api.engine.Sandbox;

public interface EventFactory {
    static <E> Event<E> createEventHandler() {
        return Sandbox.getFactoryProvider().provide(EventFactory.class).createEvent();
    }

    <E> Event<E> createEvent();
}
