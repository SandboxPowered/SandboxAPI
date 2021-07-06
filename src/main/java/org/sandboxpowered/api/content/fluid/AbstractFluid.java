package org.sandboxpowered.api.content.fluid;

import org.sandboxpowered.api.content.item.ItemStack;

public abstract class AbstractFluid implements Fluid {
    @Override
    public ItemStack getBucket() {
        return ItemStack.empty();
    }
}
