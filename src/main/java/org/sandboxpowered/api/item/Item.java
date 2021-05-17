package org.sandboxpowered.api.item;

import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.item.tool.ToolMaterial;
import org.sandboxpowered.api.item.tool.ToolType;
import org.sandboxpowered.api.registry.RegistryEntry;
import org.sandboxpowered.api.world.state.BlockState;

import java.util.Set;

public interface Item extends RegistryEntry<Item> {

    Properties getProperties();

    default ItemStack getRecipeRemainder(ItemStack original) {
        return ItemStack.empty();
    }

    boolean shouldRenderStackCount(ItemStack stack);

    boolean showEnchantmentGlint(ItemStack stack);

    float getMiningSpeed(ItemStack stack, BlockState state);

    boolean isEffectiveOn(ItemStack stack, BlockState state);

    boolean isCorrectToolForDrops(ItemStack stack, BlockState state);

    interface Properties {
        static Builder builder() {
            return Sandbox.getFactoryProvider().provide(PropertiesFactory.class).createBuilder();
        }

        int getMaxStackSize();

        int getDurability();

        int getToolLevel(ToolType type);

        Set<ToolType> getToolTypes();

        interface Builder {
            Builder setMaxStackSize(int stackSize);

            Builder setDurability(int damage);

            Builder setDefaultDurability(int damage);

            Builder addToolLevel(ToolType type, int level);
            Builder addToolTypes(ToolType type, ToolMaterial material);

            Builder addToolLevels(int level, ToolType... types);
            Builder addToolTypes(ToolMaterial material, ToolType... types);

            Properties build();
        }

        interface PropertiesFactory {
            Builder createBuilder();
        }
    }
}
