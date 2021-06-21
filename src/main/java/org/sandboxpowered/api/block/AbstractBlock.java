package org.sandboxpowered.api.block;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.registry.RegistryObject;
import org.sandboxpowered.api.util.QuantumReference;
import org.sandboxpowered.api.world.state.BlockState;
import org.sandboxpowered.api.world.state.StateProvider;

public class AbstractBlock implements Block {
    private final QuantumReference<Item> cachedItem = new QuantumReference<>();
    private final StateProvider<Block, BlockState> stateProvider = Sandbox.getFactoryProvider().provide(StateProvider.StateFactory.class).create(this);
    private final Properties properties;

    public AbstractBlock(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public StateProvider<Block, BlockState> getStateProvider() {
        return stateProvider;
    }

    @Override
    @Nullable
    public Item asItem() {
        if (!cachedItem.isStored()) {
            synchronized (cachedItem) {
                final RegistryObject<Item> item = Item.REGISTRY.get(getIdentifier());
                if (item.isPresent()) cachedItem.store(item.get());
            }
        }
        return cachedItem.get();
    }
}