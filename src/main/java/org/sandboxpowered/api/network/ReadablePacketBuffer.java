package org.sandboxpowered.api.network;

import org.sandboxpowered.api.util.Identifier;
import org.sandboxpowered.api.util.math.Position;

public interface ReadablePacketBuffer {
    String readString();

    String readString(int maxLength);

    float readFloat();

    int readInt();

    long readLong();

    Position readPosition();

    Identifier readIdentifier();
}
