package org.sandboxpowered.api.addon;

public enum PlatformSupport {
    /**
     * This platform is definitely supported.
     */
    YES,
    /**
     * It is not known whether this platform is supported.
     */
    MAYBE,
    /**
     * This platform is definitely not supported.
     */
    NO;

    public boolean canRun() {
        return this != NO;
    }
}
