package org.sandboxpowered.example;

import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.addon.SandboxAPI;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.engine.Platform;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.InventoryComponent;
import org.sandboxpowered.api.entity.PositionComponent;
import org.sandboxpowered.api.item.*;
import org.sandboxpowered.api.network.Packet;
import org.sandboxpowered.api.network.PacketBuffer;
import org.sandboxpowered.api.world.World;

public class ExampleAddon implements Addon {
    @Override
    public void setup(SandboxAPI api) {
        final var itemRegistrar = api.getRegistrar(Item.REGISTRY);
        final var blockRegistrar = api.getRegistrar(Block.REGISTRY);

        final var exampleItem = itemRegistrar.register("example_item", () -> Item.create(Item.Properties.builder().build()));
        final var explodingStaff = itemRegistrar.register("exploding_staff", () -> new ExplodingStaffItem(Item.Properties.builder().build(), exampleItem.get()));

        Sandbox.getGame().registerPacket(ExamplePacket.class, ExamplePacket::new, Platform.Type.SERVER);
    }
}
