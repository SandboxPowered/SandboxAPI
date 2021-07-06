package org.sandboxpowered.api.content.block;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.content.item.Item;
import org.sandboxpowered.api.engine.Sandbox;
import org.sandboxpowered.api.registry.RegistryObject;
import org.sandboxpowered.api.util.QuantumReference;
import org.sandboxpowered.api.world.state.BlockState;
import org.sandboxpowered.api.world.state.StateProvider;

public class AbstractBlock implements Block {
    private final QuantumReference<Item> cachedItem = new QuantumReference<>();
    private final StateProvider<Block, BlockState> stateProvider;
    private final Properties properties;
    private final BlockState defaultState;

    public AbstractBlock(Properties properties) {
        this.properties = properties;
        StateProvider.StateFactory stateFactory = Sandbox.getFactoryProvider().provide(StateProvider.StateFactory.class);
        StateProvider.Builder<Block, BlockState> builder = stateFactory.createBuilder(this);
        appendProperties(builder);
        this.stateProvider = stateFactory.create(builder);
        this.defaultState = createDefaultState(stateProvider.getBaseState());
    }

    @Override
    public BlockState getDefaultState() {
        return defaultState;
    }

    protected BlockState createDefaultState(BlockState base) {
        return base;
    }

    protected void appendProperties(StateProvider.Builder<Block, BlockState> builder) {

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