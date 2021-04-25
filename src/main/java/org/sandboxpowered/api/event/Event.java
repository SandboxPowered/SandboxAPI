package org.sandboxpowered.api.event;

public interface Event<T> {
    T invoker();

    void subscribe(T subscriber);

    void unsubscribe(T subscriber);

    boolean hasSubscribers();

    void clear();
}
