package org.sandboxpowered.api;

import com.google.inject.Inject;
import org.sandboxpowered.api.engine.Game;

import java.util.Objects;

public final class Sandbox {
    @Inject
    private static Game game;

    public static Game game() {
        Objects.requireNonNull(game, "Sandbox has not been initialized!");
        return game;
    }
}
