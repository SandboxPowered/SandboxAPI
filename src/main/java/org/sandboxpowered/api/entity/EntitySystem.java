package org.sandboxpowered.api.entity;

/**
 * Flow:
 * {@link #initialize()} - Initialize your system.
 * {@link #process()} - Called once per cycle.
 */
public interface EntitySystem {

    /**
     * Process system.
     * <p>
     * Does nothing if the system is disabled.
     */
    void process();

    void initialize();
}
