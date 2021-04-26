package org.sandboxpowered.api.item;

import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.registry.RegistryEntry;

public interface Item extends RegistryEntry<Item> {

    Properties getProperties();

    default ItemStack getRecipeRemainder(ItemStack original) {
        return ItemStack.empty();
    }

    interface Properties {
        static Builder builder() {
            return Sandbox.getFactoryProvider().provide(PropertiesFactory.class).createBuilder();
        }

        int getMaxStackSize();

        int getMaxDamage();

        interface Builder {
            Builder setMaxStackSize(int stackSize);

            Builder setMaxDamage(int damage);

            Properties build();
        }

        interface PropertiesFactory {
            Builder createBuilder();
        }
    }
}
