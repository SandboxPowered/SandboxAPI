package org.sandboxpowered.api.item;

import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.enchantment.Enchantment;

public interface ItemStack {
    static ItemStack empty() {
        return Sandbox.getFactoryProvider().provide(ItemStackFactory.class).empty();
    }

    static ItemStack of(ItemProvider provider, int count) {
        return Sandbox.getFactoryProvider().provide(ItemStackFactory.class).createItemStack(provider, count);
    }

    static ItemStack of(ItemProvider provider) {
        return of(provider, 1);
    }

    Item getItem();

    int getCount();

    boolean isEmpty();

    boolean contains(Enchantment enchantment);

    int getLevel(Enchantment enchantment);

    Enchantment[] getEnchantments();

    interface ItemStackFactory {
        ItemStack empty();

        ItemStack createItemStack(ItemProvider provider, int count);
    }
}
