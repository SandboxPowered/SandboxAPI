package org.sandboxpowered.api.block;

import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.item.ItemProvider;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.registry.RegistryEntry;
import org.sandboxpowered.api.registry.RegistryFactory;
import org.sandboxpowered.api.world.state.BlockState;
import org.sandboxpowered.api.world.state.StateProvider;

public interface Block extends RegistryEntry<Block>, ItemProvider {
    Registry<Block> REGISTRY = RegistryFactory.getRegistry(Block.class);

    static Block create(Properties properties) {
        return new AbstractBlock() {
        };
    }

    default BlockState getDefaultState() {
        return getStateProvider().getBaseState();
    }

    StateProvider<Block, BlockState> getStateProvider();

    @Override
    default Registry<Block> getRegistry() {
        return REGISTRY;
    }

    interface Properties {
        static Properties.Builder builder(Material material) {
            return Sandbox.getFactoryProvider().provide(Properties.PropertiesFactory.class).createBuilder(material);
        }

        interface Builder {
            Properties build();
        }

        interface PropertiesFactory {
            Properties.Builder createBuilder(Material material);
        }
    }
}
