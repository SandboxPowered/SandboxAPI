package org.sandboxpowered.api.content.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.content.entity.Entity;
import org.sandboxpowered.api.content.entity.component.InventoryComponent;
import org.sandboxpowered.api.content.item.attribute.Attribute;
import org.sandboxpowered.api.content.item.tool.ToolMaterial;
import org.sandboxpowered.api.content.item.tool.ToolType;
import org.sandboxpowered.api.engine.Sandbox;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.registry.RegistryEntry;
import org.sandboxpowered.api.registry.RegistryFactory;
import org.sandboxpowered.api.util.EquipmentSlot;
import org.sandboxpowered.api.util.TypedActionResult;
import org.sandboxpowered.api.util.math.Maths;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.state.BlockState;

import java.util.Set;

public interface Item extends RegistryEntry<Item>, ItemProvider {
    Registry<Item> REGISTRY = RegistryFactory.getRegistry(Item.class);

    static Item create(Properties properties) {
        return new AbstractItem(properties);
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

    default boolean shouldRenderStackCount(ItemStack stack) {
        return stack.getCount() > 1;
    }

    default boolean showEnchantmentGlint(ItemStack stack) {
        return stack.isEnchanted();
    }

    default float getMiningSpeed(ItemStack stack, BlockState state) {
        return 1;
    }

    default boolean isEffectiveOn(ItemStack stack, BlockState state) {
        return false;
    }

    default boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return false;
    }

    default Multimap<Attribute, Attribute.Modifier> getAttributeModifiers(EquipmentSlot slot) {
        return ImmutableMultimap.of();
    }

    default boolean showDurabilityBar(ItemStack stack) {
        return stack.isDamageable() && stack.isDamaged();
    }

    default float getDurabilityBarValue(ItemStack stack) {
        if (!stack.isDamageable())
            return 0;
        return 1 - stack.getCurrentDamage() / (float) stack.getMaxDamage();
    }

    default int getDurabilityBarColor(ItemStack stack) {
        if (!stack.isDamageable())
            return -1;
        float hue = (stack.getMaxDamage() - stack.getCurrentDamage()) / (float) stack.getMaxDamage();
        return Maths.hsvToRgb(hue / 3f, 1f, 1f);
    }

    /**
     * @param world The world in which the entity using the item exists
     * @param user  The entity using the item, has {@link InventoryComponent}
     */
    TypedActionResult<ItemStack> use(World world, ItemStack stack, Entity user, Hand hand);

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
