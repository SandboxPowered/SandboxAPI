package org.sandboxpowered.example;

import org.sandboxpowered.api.content.entity.Entity;
import org.sandboxpowered.api.network.NetworkContext;
import org.sandboxpowered.api.network.Packet;
import org.sandboxpowered.api.network.ReadablePacketBuffer;
import org.sandboxpowered.api.network.WritablePacketBuffer;

public class ExamplePacket implements Packet {
    private final float x, y, z;

    public ExamplePacket(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public ExamplePacket(ReadablePacketBuffer buffer) {
        x = buffer.readFloat();
        y = buffer.readFloat();
        z = buffer.readFloat();
    }

    @Override
    public void write(WritablePacketBuffer buffer) {
        buffer.writeFloat(x);
        buffer.writeFloat(y);
        buffer.writeFloat(z);
    }

    @Override
    public void handle(NetworkContext context) {
        Entity sender = context.getSender();
        if (sender != null)
            sender.getWorld().explode(sender, x, y, z, 2f, true, true);
    }
}
