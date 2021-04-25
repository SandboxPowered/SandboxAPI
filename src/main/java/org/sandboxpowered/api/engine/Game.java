package org.sandboxpowered.api.engine;

import org.sandboxpowered.api.client.Client;
import org.sandboxpowered.api.engine.Engine.UnsupportedEngineException;
import org.sandboxpowered.api.server.Server;

import java.nio.file.Path;

public interface Game {
    Path getGameDirectory();

    Platform getPlatform();

    boolean isServerAvailable();

    Server getServer() throws UnsupportedEngineException;

    boolean isClientAvailable();

    Client getClient() throws UnsupportedEngineException;
}
