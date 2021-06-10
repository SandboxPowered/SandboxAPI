package org.sandboxpowered.api.entity;

import org.jetbrains.annotations.ApiStatus;
import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.item.Hand;

import java.util.stream.Stream;

public interface ItemSlot {
    ItemSlot FEET = byName("feet");
    ItemSlot LEGS = byName("legs");
    ItemSlot CHEST = byName("chest");
    ItemSlot HEAD = byName("head");

    static Stream<ItemSlot> slots() {
        return Stream.concat(
                Stream.of(Hand.MAIN_HAND, Hand.OFF_HAND),
                Sandbox.getFactoryProvider().provide(ItemSlotFactory.class).getAllSlots()
        );
    }

    @ApiStatus.Internal
    static ItemSlot byName(String name) {
        return Sandbox.getFactoryProvider().provide(ItemSlotFactory.class).getArmor(name);
    }

    boolean isArmor();

    interface ItemSlotFactory {
        ItemSlot getArmor(String name);

        Stream<ItemSlot> getAllSlots();
    }
}
