package org.sandboxpowered.api.fluid;

import org.sandboxpowered.api.item.ItemStack;

public abstract class AbstractFluid implements Fluid {
    @Override
    public ItemStack getBucket() {
        return ItemStack.empty();
    }
}
