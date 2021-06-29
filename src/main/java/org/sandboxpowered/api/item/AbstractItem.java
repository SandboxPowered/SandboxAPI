package org.sandboxpowered.api.item;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.component.InventoryComponent;
import org.sandboxpowered.api.util.TypedActionResult;
import org.sandboxpowered.api.world.World;

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
    public TypedActionResult<ItemStack> use(World world, ItemStack stack, Entity user, Hand hand) {
        return TypedActionResult.pass(stack);
    }
}
