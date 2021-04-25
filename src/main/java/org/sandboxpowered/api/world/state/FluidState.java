package org.sandboxpowered.api.world.state;

import org.sandboxpowered.api.fluid.Fluid;

public interface FluidState extends PropertyContainer<FluidState> {
    Fluid getFluid();
}
