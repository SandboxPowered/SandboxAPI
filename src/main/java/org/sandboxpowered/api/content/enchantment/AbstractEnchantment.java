package org.sandboxpowered.api.content.enchantment;

import org.jetbrains.annotations.Range;
import org.sandboxpowered.api.content.item.ItemStack;

//TODO this needs finalizing
public abstract class AbstractEnchantment implements Enchantment {
    private final Rarity rarity;

    public AbstractEnchantment(Rarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public ItemStack getEnchantedBook() {
        return ItemStack.empty();
    }

    @Override
    public ItemStack getEnchantedBook(int level) {
        return getEnchantedBook();
    }

    @Override
    public @Range(from = 1, to = Integer.MAX_VALUE) int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isCompatible(Enchantment other) {
        return true;
    }

    @Override
    public boolean canApplyOn(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isCurse() {
        return false;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }
}
