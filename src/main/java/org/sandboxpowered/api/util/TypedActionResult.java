package org.sandboxpowered.api.util;

public record TypedActionResult<T>(T result, ActionResult actionResult) {
    public static <T> TypedActionResult<T> success(T result) {
        return new TypedActionResult<>(result, ActionResult.SUCCESS);
    }

    public static <T> TypedActionResult<T> consume(T result) {
        return new TypedActionResult<>(result, ActionResult.CONSUME);
    }

    public static <T> TypedActionResult<T> pass(T result) {
        return new TypedActionResult<>(result, ActionResult.PASS);
    }

    public static <T> TypedActionResult<T> fail(T result) {
        return new TypedActionResult<>(result, ActionResult.FAIL);
    }

}
