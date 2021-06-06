package org.sandboxpowered.api.fluid;

import org.sandboxpowered.api.enchantment.Enchantment;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.registry.RegistryEntry;
import org.sandboxpowered.api.registry.RegistryFactory;

public interface Fluid extends RegistryEntry<Fluid> {
    Registry<Fluid> REGISTRY = RegistryFactory.getRegistry(Fluid.class);

    ItemStack getBucket();
}
