package org.sandboxpowered.api.enchantment;

import org.jetbrains.annotations.Range;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.registry.RegistryEntry;
import org.sandboxpowered.api.registry.RegistryFactory;

public interface Enchantment extends RegistryEntry<Enchantment> {
    Registry<Enchantment> REGISTRY = RegistryFactory.getRegistry(Enchantment.class);

    static Enchantment create(Rarity rarity) {
        return new AbstractEnchantment(rarity) {
        };
    }

    ItemStack getEnchantedBook();

    ItemStack getEnchantedBook(int level);

    @Range(from = 1, to = Integer.MAX_VALUE)
    int getMaxLevel();

    /**
     * @return whether this enchantment is compatible with the other
     */
    boolean isCompatible(Enchantment other);

    /**
     * @return whether this enchantment can be applied on the specified item
     */
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

    Rarity getRarity();

    @Override
    default Registry<Enchantment> getRegistry() {
        return REGISTRY;
    }

    enum Rarity {
        COMMON(10),
        UNCOMMON(5),
        RARE(2),
        VERY_RARE(1);

        private final int weight;

        Rarity(int weight) {
            this.weight = weight;
        }

        @Range(from = 1, to = 10)
        public int getWeight() {
            return weight;
        }
    }
}
