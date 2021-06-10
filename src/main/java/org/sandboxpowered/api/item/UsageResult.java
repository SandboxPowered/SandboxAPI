package org.sandboxpowered.api.item;

public record UsageResult<T>(T result, Type type) {
    public static <T> UsageResult<T> success(T result) {
        return new UsageResult<>(result, Type.SUCCESS);
    }

    public static <T> UsageResult<T> consume(T result) {
        return new UsageResult<>(result, Type.CONSUME);
    }

    public static <T> UsageResult<T> pass(T result) {
        return new UsageResult<>(result, Type.PASS);
    }

    public static <T> UsageResult<T> fail(T result) {
        return new UsageResult<>(result, Type.FAIL);
    }

    public enum Type {
        SUCCESS,
        CONSUME,
        PASS,
        FAIL
    }
}
