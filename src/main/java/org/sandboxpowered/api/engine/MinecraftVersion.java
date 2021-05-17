package org.sandboxpowered.api.engine;

public interface MinecraftVersion extends Comparable<MinecraftVersion> {

    String getName();

    boolean isAtLeast(MinecraftVersion version);

    boolean isPatchVersionOf(MinecraftVersion version);

    boolean isSnapshot();

    boolean isPreRelease();

}
