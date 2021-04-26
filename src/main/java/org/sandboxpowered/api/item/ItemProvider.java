package org.sandboxpowered.api.item;

import org.jetbrains.annotations.Contract;

public interface ItemProvider {
    @Contract(pure = true)
    Item asItem();

    default ItemStack createStack() {
        return ItemStack.of(this);
    }

    default ItemStack createStack(int count) {
        return ItemStack.of(this, count);
    }
}
