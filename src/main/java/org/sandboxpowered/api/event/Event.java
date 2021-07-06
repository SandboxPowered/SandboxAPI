package org.sandboxpowered.api.event;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public interface Event<E> {
    void post(Consumer<E> eventConsumer);

    <R> R postReturnable(BiFunction<E, R, R> eventConsumer, R defaultValue);

    void subscribe(E eventCall);

    void subscribe(Priority priority, E eventCall);

    void unsubscribe(E eventCall);

    boolean hasSubscribers();

    enum Priority {
        LOWEST,
        LOW,
        NORMAL,
        HIGH,
        HIGHEST,
        FINAL;

        public static final Priority[] VALUES = Priority.values();
    }
}
