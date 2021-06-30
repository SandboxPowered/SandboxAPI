package org.sandboxpowered.example;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.component.InventoryComponent;
import org.sandboxpowered.api.entity.component.PositionComponent;
import org.sandboxpowered.api.item.AbstractItem;
import org.sandboxpowered.api.item.Hand;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.ItemStack;
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
        final var positionComponent = user.getComponent(PositionComponent.class);
        if (inventory != null && positionComponent != null && inventory.get(hand.opposite()).getItem() == offHandItem) {
            final var position = positionComponent.getPos();
            world.explode(user, position.x(), position.y(), position.z(), 1f, true, true);
            stack.damage(1, user);
            return TypedActionResult.success(stack);
        }
        return TypedActionResult.fail(stack);
    }
}
