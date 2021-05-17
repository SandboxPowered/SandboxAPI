package org.sandboxpowered.example;

import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.addon.SandboxAPI;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.item.Item;

public class ExampleAddon implements Addon {
    @Override
    public void setup(SandboxAPI api) {
        var itemRegistrar = api.registrar(Item.class);
        var blockRegistrar = api.registrar(Block.class);
    }
}
