package org.sandboxpowered.api.content.item;

import org.sandboxpowered.api.content.entity.ItemSlot;

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
