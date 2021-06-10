package org.sandboxpowered.example;

import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.addon.SandboxAPI;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.InventoryComponent;
import org.sandboxpowered.api.entity.PositionComponent;
import org.sandboxpowered.api.item.*;
import org.sandboxpowered.api.registry.RegistryObject;
import org.sandboxpowered.api.world.World;

public class ExampleAddon implements Addon {
    @Override
    public void setup(SandboxAPI api) {
        final var itemRegistrar = api.getRegistrar(Item.REGISTRY);
        final var blockRegistrar = api.getRegistrar(Block.REGISTRY);

        final var exampleItem = itemRegistrar.register("example_item", () -> Item.create(Item.Properties.builder().build()));
        final var explodingStaff = itemRegistrar.register("exploding_staff", () -> new ExplodingStaffItem(Item.Properties.builder().build(), exampleItem.get()));
    }

    public static class ExplodingStaffItem extends AbstractItem {
        private final Item offHandItem;

        public ExplodingStaffItem(Properties properties, Item offHandItem) {
            super(properties);
            this.offHandItem = offHandItem;
        }

        @Override
        public UsageResult<ItemStack> use(World world, Entity user, Hand hand) {
            final var inventory = user.getComponent(InventoryComponent.class);
            final var stack = inventory.get(hand);
            if (user.hasComponent(PositionComponent.class) && inventory.get(hand.opposite()).getItem() == offHandItem) {
                final var position = user.getComponent(PositionComponent.class).getPos();
                world.explode(user, position.x(), position.y(), position.z(), 1f, true, true);
                stack.damage(1, user);
                return UsageResult.success(stack);
            }
            return UsageResult.fail(stack);
        }
    }
}
