package org.sandboxpowered.api.engine;

import com.google.inject.Inject;
import org.sandboxpowered.api.client.Client;
import org.sandboxpowered.api.engine.Engine.UnsupportedEngineException;
import org.sandboxpowered.api.server.Server;

import java.util.Objects;

public final class Sandbox {
    @Inject
    private static Game game;

    public static Game getGame() {
        Objects.requireNonNull(game, "Sandbox has not been initialized!");
        return game;
    }

    public static FactoryProvider getFactoryProvider() {
        return getGame().getFactoryProvider();
    }

    public static boolean isClientAvailable() {
        return getGame().isClientAvailable();
    }

    public static Client getClient() throws UnsupportedEngineException {
        return getGame().getClient();
    }

    public static boolean isServerAvailable() {
        return getGame().isServerAvailable();
    }

    public static Server getServer() throws UnsupportedEngineException {
        return getGame().getServer();
    }
}
