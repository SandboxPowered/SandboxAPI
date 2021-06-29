package org.sandboxpowered.api.engine.inject;

import com.google.inject.PrivateModule;
import org.sandboxpowered.api.engine.Game;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public class ImplementationModule extends PrivateModule {
    @Override
    @OverridingMethodsMustInvokeSuper
    protected void configure() {
        expose(Game.class);
    }
}
