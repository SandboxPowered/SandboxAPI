package org.sandboxpowered.api.engine;

import org.sandboxpowered.api.client.Client;
import org.sandboxpowered.api.server.Server;
import org.sandboxpowered.api.util.Documented;

/**
 * Base engine functionality for {@link Client} and {@link Server}.
 */
public interface Engine {

    Game getGame();

    @Documented("please specify documentation URL")
    class UnsupportedEngineException extends RuntimeException {
        public UnsupportedEngineException() {
        }

        public UnsupportedEngineException(String message) {
            super(message);
        }

        public UnsupportedEngineException(String message, Throwable cause) {
            super(message, cause);
        }

        public UnsupportedEngineException(Throwable cause) {
            super(cause);
        }
    }
}
