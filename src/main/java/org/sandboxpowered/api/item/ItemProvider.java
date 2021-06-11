package org.sandboxpowered.api.item;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public interface ItemProvider {
    @Contract(pure = true)
    @Nullable
    Item asItem();

    default ItemStack createStack() {
        return ItemStack.of(this);
    }

    default ItemStack createStack(int count) {
        return ItemStack.of(this, count);
    }
}
