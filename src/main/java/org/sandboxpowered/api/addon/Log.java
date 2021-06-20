package org.sandboxpowered.api.addon;

public interface Log {
    void debug(String message);

    void debug(String message, Object... vars);

    void info(String message);

    void info(String message, Object... vars);

    void warn(String message);

    void warn(String message, Object... vars);

    void error(String message);

    void error(String message, Object... vars);

    void error(String message, Throwable throwable);
}