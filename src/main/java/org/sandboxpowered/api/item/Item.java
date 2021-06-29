package org.sandboxpowered.api.item;

import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.component.InventoryComponent;
import org.sandboxpowered.api.item.tool.ToolMaterial;
import org.sandboxpowered.api.item.tool.ToolType;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.registry.RegistryEntry;
import org.sandboxpowered.api.registry.RegistryFactory;
import org.sandboxpowered.api.util.TypedActionResult;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.state.BlockState;

import java.util.Set;

public interface Item extends RegistryEntry<Item>, ItemProvider {
    Registry<Item> REGISTRY = RegistryFactory.getRegistry(Item.class);

    static Item create(Properties properties) {
        return new AbstractItem(properties) {
        };
    }

    @Override
    @NotNull
    default Item asItem() {
        return this;
    }

    Properties getProperties();

    default ItemStack getRecipeRemainder(ItemStack original) {
        return ItemStack.empty();
    }

    boolean shouldRenderStackCount(ItemStack stack);

    boolean showEnchantmentGlint(ItemStack stack);

    float getMiningSpeed(ItemStack stack, BlockState state);

    boolean isEffectiveOn(ItemStack stack, BlockState state);

    boolean isCorrectToolForDrops(ItemStack stack, BlockState state);

    /**
     * @param world The world in which the entity using the item exists
     * @param user  The entity using the item, has {@link InventoryComponent}
     */
    TypedActionResult<ItemStack> use(World world, Entity user, Hand hand);

    @Override
    default Registry<Item> getRegistry() {
        return REGISTRY;
    }

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
