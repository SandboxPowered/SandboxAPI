package org.sandboxpowered.api.item;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.InventoryComponent;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.state.BlockState;

public abstract class AbstractItem implements Item {
    private final Properties properties;

    public AbstractItem(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public boolean shouldRenderStackCount(ItemStack stack) {
        return true;
    }

    @Override
    public boolean showEnchantmentGlint(ItemStack stack) {
        return stack.getEnchantments().length != 0;
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        return 0;
    }

    @Override
    public boolean isEffectiveOn(ItemStack stack, BlockState state) {
        return false;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return false;
    }

    @Override
    public UsageResult<ItemStack> use(World world, Entity user, Hand hand) {
        return UsageResult.pass(user.getComponent(InventoryComponent.class).get(hand));
    }
}
