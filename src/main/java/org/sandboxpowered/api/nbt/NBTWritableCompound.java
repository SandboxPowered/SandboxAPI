package org.sandboxpowered.api.nbt;

import org.sandboxpowered.api.util.Identifier;
import org.sandboxpowered.api.util.math.Position;

import java.util.List;
import java.util.UUID;

public interface NBTWritableCompound extends NBT {
    void setInt(String key, int i);

    void setIntArray(String key, int[] i);

    void setString(String key, String s);

    void setDouble(String key, double d);

    void setByte(String key, byte b);

    void setByteArray(String key, byte[] b);

    void setLong(String key, long l);

    void setBoolean(String key, boolean bool);

    void setUUID(String key, UUID uuid);

    void setTag(String key, NBT tag);

    <T extends NBT> void setList(String key, List<T> list);

    void setPosition(String key, Position position);

    void setIdentifier(String key, Identifier identifier);
}
