package org.sandboxpowered.api.world.state;

import org.sandboxpowered.api.content.block.Block;

public interface BlockState extends PropertyContainer<BlockState> {
    Block getBlock();
}
