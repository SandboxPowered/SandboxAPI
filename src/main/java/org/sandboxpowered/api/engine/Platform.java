package org.sandboxpowered.api.engine;

public interface Platform {
    /**
     * Gets the current Minecraft version of this platform.
     *
     * @return The Minecraft version
     */
    MinecraftVersion getMinecraftVersion();

    /**
     * Gets the current {@link Type} this platform is on.
     *
     * @return The current type
     */
    Type getType();

    /**
     * Gets the current {@link Type} this platform is executing on.
     *
     * <p>Minecraft has a Client and Server thread,
     * if the server thread is executing then this will return {@link Type#SERVER}
     * or if the client thread is executing then this will return {@link Type#CLIENT}.</p>
     *
     * @return The executing type
     */
    Type getExecutingType();

    enum Type {
        CLIENT,
        SERVER;

        public boolean isServer() {
            return this == SERVER;
        }

        public boolean isClient() {
            return this == CLIENT;
        }
    }
}
