package org.sandboxpowered.example;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.component.InventoryComponent;
import org.sandboxpowered.api.entity.component.PositionComponent;
import org.sandboxpowered.api.item.*;
import org.sandboxpowered.api.util.TypedActionResult;
import org.sandboxpowered.api.world.World;

public class ExplodingStaffItem extends AbstractItem {
    private final Item offHandItem;

    public ExplodingStaffItem(Properties properties, Item offHandItem) {
        super(properties);
        this.offHandItem = offHandItem;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, ItemStack stack, Entity user, Hand hand) {
        final var inventory = user.getComponent(InventoryComponent.class);
        if (user.hasComponent(PositionComponent.class) && inventory.get(hand.opposite()).getItem() == offHandItem) {
            final var position = user.getComponent(PositionComponent.class).getPos();
            world.explode(user, position.x(), position.y(), position.z(), 1f, true, true);
            stack.damage(1, user);
            return TypedActionResult.success(stack);
        }
        return TypedActionResult.fail(stack);
    }
}
