package org.sandboxpowered.api.enchantment;

import org.jetbrains.annotations.Range;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.RegistryEntry;

public interface Enchantment extends RegistryEntry<Enchantment> {
    ItemStack getEnchantedBook();

    ItemStack getEnchantedBook(int level);

    @Range(from = 1, to = Integer.MAX_VALUE)
    int getMaxLevel();

    boolean isCompatible(Enchantment other);

    boolean canApplyOn(ItemStack stack);

    /**
     * @return whether the enchantment should be considered a curse,
     * and be displayed in red color
     */
    boolean isCurse();

    /**
     * @return whether the enchantment can only be found on treasure items,
     * and <strong>not</strong> be applied at an enchanting table
     */
    boolean isTreasure();
}
