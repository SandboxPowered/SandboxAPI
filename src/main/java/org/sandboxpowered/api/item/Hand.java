package org.sandboxpowered.api.item;

import org.sandboxpowered.api.entity.ItemSlot;

public enum Hand implements ItemSlot {
    MAIN_HAND,
    OFF_HAND;

    public Hand opposite() {
        return this == MAIN_HAND ? OFF_HAND : MAIN_HAND;
    }

    @Override
    public boolean isArmor() {
        return false;
    }
}
