package org.sandboxpowered.api.fluid;

import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.internal.InternalService;

public interface FluidStack {
    static FluidStack of(Fluid fluid) {
        return of(fluid, 1000);
    }

    static FluidStack of(Fluid fluid, int amount) {
        return InternalService.getInstance().fluidStackFunction(fluid, amount);
    }

    static FluidStack empty() {
        return of(Fluids.EMPTY.get(), 0);
    }

    static FluidStack read(ReadableCompoundTag tag) {
        return InternalService.getInstance().fluidStackFromTagFunction(tag);
    }

    boolean isEmpty();

    Fluid getFluid();

    int getVolume();

    FluidStack setVolume(int volume);

    FluidStack copy();

    default FluidStack shrink() {
        return shrink(1);
    }

    FluidStack shrink(int amount);

    default FluidStack grow() {
        return shrink(1);
    }

    FluidStack grow(int amount);

    boolean hasTag();

    CompoundTag getTag();

    void setTag(CompoundTag stackTag);

    CompoundTag getOrCreateTag();

    CompoundTag getChildTag(String key);

    CompoundTag getOrCreateChildTag(String key);

    CompoundTag asTag();

    default <X> Mono<X> getComponent(Component<X> component) {
        return getFluid().getComponent(component, this);
    }

    boolean isEqualTo(FluidStack stack);

    boolean areTagsEqual(FluidStack stack);
}
