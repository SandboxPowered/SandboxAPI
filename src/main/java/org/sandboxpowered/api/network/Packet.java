package org.sandboxpowered.api.network;

public interface Packet {
    void write(WritablePacketBuffer buffer);

    void handle(NetworkContext context);
}
