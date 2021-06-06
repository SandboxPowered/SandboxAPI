package org.sandboxpowered.example;

import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.addon.SandboxAPI;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.registry.RegistryObject;

public class ExampleAddon implements Addon {
    @Override
    public void setup(SandboxAPI api) {
        var itemRegistrar = api.getRegistrar(Item.REGISTRY);
        var blockRegistrar = api.getRegistrar(Block.REGISTRY);

        RegistryObject<Item> exampleItem = itemRegistrar.register("example_item", () -> Item.create(Item.Properties.builder().build()));
    }
}
