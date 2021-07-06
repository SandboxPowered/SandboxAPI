package org.sandboxpowered.api.world;

import org.sandboxpowered.api.content.entity.Entity;

public interface World extends WorldReader, WorldWriter {
    DimensionType getType();

    /**
     * @param triggerEntity  The entity that caused this explosion, or -1 if none
     * @param size           The size/power of the explosion
     * @param createsFires   Whether it creates fires or not
     * @param destroysBlocks Whether this explosion destroys the terrain around it
     */
    Explosion createExplosion(Entity triggerEntity, float x, float y, float z, float size, boolean createsFires, boolean destroysBlocks);

    /**
     * Creates an explosion like {@link World#createExplosion(Entity, float, float, float, float, boolean, boolean)} and triggers it
     */
    void explode(Entity triggerEntity, float x, float y, float z, float size, boolean createsFires, boolean destroysBlocks);
}
