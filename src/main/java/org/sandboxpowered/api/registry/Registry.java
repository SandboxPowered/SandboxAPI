package org.sandboxpowered.api.registry;

import org.jetbrains.annotations.ApiStatus.Experimental;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.util.Identifier;

import java.util.stream.Stream;

public interface Registry<T extends RegistryEntry<T>> extends Iterable<T>, RegistryEntry<Registry<? extends RegistryEntry<?>>> {
    Stream<T> stream();

    boolean contains(Identifier id);

    RegistryObject<T> get(Identifier id);

    Identifier getId(T element);

    @Experimental
    T getUnsafe(Identifier id);

    Class<T> getRegistryType();
}
