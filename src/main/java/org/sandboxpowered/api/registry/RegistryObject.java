package org.sandboxpowered.api.registry;

import org.jetbrains.annotations.Contract;
import org.sandboxpowered.api.util.Identifier;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

public interface RegistryObject<T extends RegistryEntry<T>> extends Supplier<T> {
    Optional<T> asOptional();

    @Contract(pure = true)
    T get() throws NoSuchElementException;

    boolean isPresent();

    boolean isEmpty();

    RegistryObject<T> or(RegistryObject<T> supplier);

    Identifier getId();

    T orElseGet(Supplier<T> supplier);

    <X extends Throwable> T orElseThrow(Supplier<X> supplier) throws X;

    Registry<T> getRegistry();
}
