package org.sandboxpowered.api.network;

public interface PacketBuffer {
    float readFloat();

    void writeFloat(float value);
}
