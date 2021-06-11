package org.sandboxpowered.api.network;

import org.sandboxpowered.api.entity.Entity;

public interface Packet {
    void write(PacketBuffer buffer);

    void handle(Entity sender);
}
