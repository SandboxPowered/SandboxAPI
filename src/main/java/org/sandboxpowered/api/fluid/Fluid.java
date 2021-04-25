package org.sandboxpowered.api.fluid;

import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.RegistryEntry;

public interface Fluid extends RegistryEntry<Fluid> {
    ItemStack getBucket();
}
