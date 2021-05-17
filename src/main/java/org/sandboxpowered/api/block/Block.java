package org.sandboxpowered.api.block;

import org.sandboxpowered.api.item.ItemProvider;
import org.sandboxpowered.api.registry.RegistryEntry;
import org.sandboxpowered.api.world.state.BlockState;

public interface Block extends RegistryEntry<Block>, ItemProvider {
    BlockState getDefaultState();


}
