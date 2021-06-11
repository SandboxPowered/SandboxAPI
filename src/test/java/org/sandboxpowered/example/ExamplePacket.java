package org.sandboxpowered.example;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.network.Packet;
import org.sandboxpowered.api.network.PacketBuffer;

public class ExamplePacket implements Packet {
    private final float x, y, z;

    public ExamplePacket(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public ExamplePacket(PacketBuffer buffer) {
        x = buffer.readFloat();
        y = buffer.readFloat();
        z = buffer.readFloat();
    }

    @Override
    public void write(PacketBuffer buffer) {
        buffer.writeFloat(x);
        buffer.writeFloat(y);
        buffer.writeFloat(z);
    }

    @Override
    public void handle(Entity sender) {
        sender.getWorld().explode(sender, x, y, z, 2f, true, true);
    }
}
