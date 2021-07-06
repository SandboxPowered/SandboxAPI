package org.sandboxpowered.api.util.shape;

public interface ShapeCombination {
    ShapeCombination OR = (a, b) -> a || b;
    ShapeCombination AND = (a, b) -> a && b;
    ShapeCombination NOT_OR = (a, b) -> !a && !b;
    ShapeCombination NOT_AND = (a, b) -> !a || !b;
    ShapeCombination FIRST = (a, b) -> a;
    ShapeCombination ONLY_FIRST = (a, b) -> a && !b;
    ShapeCombination NOT_FIRST = (a, b) -> !a;
    ShapeCombination SECOND = (a, b) -> b;
    ShapeCombination ONLY_SECOND = (a, b) -> b && !a;
    ShapeCombination NOT_SECOND = (a, b) -> !b;
    ShapeCombination SAME = (a, b) -> a == b;
    ShapeCombination NOT_SAME = (a, b) -> a != b;
    ShapeCombination CAUSES = (a, b) -> !a || b;
    ShapeCombination CAUSED_BY = (a, b) -> a || !b;
    ShapeCombination FALSE = (a, b) -> false;
    ShapeCombination TRUE = (a, b) -> true;

    boolean combine(boolean shapeA, boolean shapeB);
}
