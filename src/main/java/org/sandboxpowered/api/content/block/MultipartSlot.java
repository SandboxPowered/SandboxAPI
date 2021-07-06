package org.sandboxpowered.api.content.block;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.util.Identifier;

public class MultipartSlot {
    /**
     * Default multipart slot.
     * <p>
     * Used for blocks which don't support Multipart behaviour.
     */
    @NotNull
    public static final MultipartSlot BLOCK = get("sandbox", "block");

    private static final LoadingCache<Identifier, MultipartSlot> SLOTS = CacheBuilder.newBuilder().build(CacheLoader.from(MultipartSlot::new));

    public static MultipartSlot get(String namespace, String path) {
        return get(Identifier.of(namespace, path));
    }

    public static MultipartSlot get(Identifier id) {
        return SLOTS.getUnchecked(id);
    }

    private MultipartSlot(Identifier name) {
        this.name = name;
    }

    private final Identifier name;

    public Identifier getName() {
        return name;
    }
}
