package org.sandboxpowered.api.nbt;

import org.sandboxpowered.api.util.Identifier;
import org.sandboxpowered.api.util.math.Position;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface NBTReadableCompound extends NBT {
    int size();

    Collection<String> getKeys();

    boolean contains(String key);

    int getInt(String key);

    int[] getIntArray(String key);

    String getString(String key);

    double getDouble(String key);

    byte getByte(String key);

    byte[] getByteArray(String key);

    long getLong(String key);

    boolean getBoolean(String key);

    UUID getUUID(String key);

    boolean remove(String key);

    NBT getTag(String key);

    <T> List<T> getList(String key, Class<T> tagType);

    NBTCompound getCompoundTag(String key);

    Identifier getIdentifier(String key);

    Position getPosition(String key);
}
