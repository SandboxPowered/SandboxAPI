package org.sandboxpowered.api.block;

import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.addon.Material;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.ItemProvider;
import org.sandboxpowered.api.item.tool.ToolMaterial;
import org.sandboxpowered.api.item.tool.ToolType;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.registry.RegistryEntry;
import org.sandboxpowered.api.registry.RegistryFactory;
import org.sandboxpowered.api.world.state.BlockState;

import java.util.Set;

public interface Block extends RegistryEntry<Block>, ItemProvider {
    Registry<Block> REGISTRY = RegistryFactory.getRegistry(Block.class);

    static Block create(Properties properties) {
        return new AbstractBlock() {
        };
    }

    default BlockState getDefaultState() {
        return Sandbox.getFactoryProvider().provide(StateFactory.class).getDefaultState(this);
    }

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

    interface StateFactory {
        BlockState getDefaultState(Block block);
    }
}
