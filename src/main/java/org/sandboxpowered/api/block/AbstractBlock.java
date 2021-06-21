package org.sandboxpowered.api.block;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.registry.RegistryObject;
import org.sandboxpowered.api.util.QuantumReference;
import org.sandboxpowered.api.world.state.BlockState;
import org.sandboxpowered.api.world.state.StateProvider;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractBlock implements Block {
    private final QuantumReference<Item> cachedItem = new QuantumReference<>();
    private final StateProvider<Block, BlockState> stateProvider = Sandbox.getFactoryProvider().provide(StateProvider.StateFactory.class).create(this);

    @Override
    public StateProvider<Block, BlockState> getStateProvider() {
        return stateProvider;
    }

    @Override
    @Nullable
    public Item asItem() {
        synchronized (cachedItem) {
            if (!cachedItem.isStored()) {
                final RegistryObject<Item> item = Item.REGISTRY.get(getIdentifier());
                if (item.isPresent()) cachedItem.store(item.get());
            }
            return cachedItem.get();
        }
    }
}