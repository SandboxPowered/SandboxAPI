package org.sandboxpowered.api.engine;

import org.sandboxpowered.api.client.Client;
import org.sandboxpowered.api.engine.Engine.UnsupportedEngineException;
import org.sandboxpowered.api.network.PacketBuffer;
import org.sandboxpowered.api.server.Server;

import java.nio.file.Path;
import java.util.function.Function;

public interface Game {
    Path getGameDirectory();

    Platform getPlatform();

    boolean isServerAvailable();

    Server getServer() throws UnsupportedEngineException;

    boolean isClientAvailable();

    Client getClient() throws UnsupportedEngineException;

    FactoryProvider getFactoryProvider();

    <T> void registerPacket(Class<T> type, Function<PacketBuffer, T> reader, Platform.Type side);
}
