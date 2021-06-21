package org.sandboxpowered.api.block;

public interface Material {

    boolean isLiquid();

    boolean isNonSolid();

    boolean doesAllowMovement();

    boolean isTransparent();

    boolean isFlammable();

    boolean isReplaceable();

    PistonBehavior getPistonBehavior();

    enum PistonBehavior {
        NORMAL,
        DESTROY,
        BLOCK,
        IGNORE,
        PUSH_ONLY
    }

    interface Builder {
        Builder liquid();

        Builder nonSolid();

        Builder allowMovement();

        Builder transparent();

        Builder flammable();

        Builder replaceable();

        Builder pistonBehavior(PistonBehavior behavior);

        Material build();
    }

    interface MaterialFactory {
        Material fromVanilla(String material);
    }
}