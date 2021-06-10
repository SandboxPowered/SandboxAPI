package org.sandboxpowered.api.block;

import org.sandboxpowered.api.item.ItemProvider;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.registry.RegistryEntry;
import org.sandboxpowered.api.registry.RegistryFactory;
import org.sandboxpowered.api.world.state.BlockState;

public interface Block extends RegistryEntry<Block>, ItemProvider {
    Registry<Block> REGISTRY = RegistryFactory.getRegistry(Block.class);

    BlockState getDefaultState();
}
