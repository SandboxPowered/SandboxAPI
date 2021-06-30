package org.sandboxpowered.example;

import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.addon.SandboxAPI;
import org.sandboxpowered.api.addon.service.resource.ResourceConstants;
import org.sandboxpowered.api.addon.service.resource.ResourceService;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.engine.Platform;
import org.sandboxpowered.api.item.Item;

public class ExampleAddon implements Addon {
    @Override
    public void setup(SandboxAPI api) {
        final var itemRegistrar = api.getRegistrar(Item.REGISTRY);
        final var blockRegistrar = api.getRegistrar(Block.REGISTRY);

        final var exampleItem = itemRegistrar.register("example_item", () -> Item.create(Item.Properties.builder().build()));
        final var explodingStaff = itemRegistrar.register("exploding_staff", () -> new ExplodingStaffItem(Item.Properties.builder().setDurability(200).build(), exampleItem.get()));

        Sandbox.getGame().registerPacket(ExamplePacket.class, ExamplePacket::new, Platform.Type.SERVER);

        api.useCreationService(ResourceService.class, service -> {
            service.add(ResourceConstants.COPPER, ResourceConstants.INGOT);
        });
    }
}
