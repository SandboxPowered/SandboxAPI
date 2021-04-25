package org.sandboxpowered.api.item;

public interface ItemStack {
    Item getItem();

    int getCount();

    boolean isEmpty();
}
