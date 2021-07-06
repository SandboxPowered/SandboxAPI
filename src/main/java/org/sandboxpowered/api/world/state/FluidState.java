package org.sandboxpowered.api.world.state;

import org.sandboxpowered.api.content.fluid.Fluid;

public interface FluidState extends PropertyContainer<FluidState> {
    Fluid getFluid();
}
