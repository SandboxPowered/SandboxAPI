package org.sandboxpowered.api.world;

public interface World extends WorldReader, WorldWriter {
    DimensionType getType();
}
