package org.sandboxpowered.api.content.item;

import org.sandboxpowered.api.content.enchantment.Enchantment;
import org.sandboxpowered.api.content.entity.Entity;
import org.sandboxpowered.api.engine.Sandbox;

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

    void damage(int amount, Entity user);

    boolean isDamageable();

    boolean isDamaged();

    int getCurrentDamage();

    int getMaxDamage();

    boolean isEnchanted();

    interface ItemStackFactory {
        ItemStack empty();

        ItemStack createItemStack(ItemProvider provider, int count);
    }
}
