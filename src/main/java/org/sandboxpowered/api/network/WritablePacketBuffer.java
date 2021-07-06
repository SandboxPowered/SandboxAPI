package org.sandboxpowered.api.network;

import org.sandboxpowered.api.util.Identifier;
import org.sandboxpowered.api.util.math.Position;

public interface WritablePacketBuffer {
    void writeString(String value);

    void writeString(String value, int maxLength);

    void writeFloat(float value);

    void writeInt(int value);

    void writeLong(long value);

    void writePosition(Position position);

    void writeIdentifier(Identifier identifier);
}
