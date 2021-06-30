package org.sandboxpowered.api.nbt;

import org.sandboxpowered.api.Sandbox;

public interface NBTCompound extends NBTReadableCompound, NBTWritableCompound, NBT {
    static NBTCompound create() {
        return Sandbox.getFactoryProvider().provide(NBTFactory.class).createCompoundNBT();
    }
}
