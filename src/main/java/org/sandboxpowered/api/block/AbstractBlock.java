package org.sandboxpowered.api.block;

import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.registry.RegistryObject;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractBlock implements Block {
    private final AtomicBoolean hasItemCache = new AtomicBoolean();
    private volatile Item cachedItem;

    @Override
    public Item asItem() {
        if (!hasItemCache.get()) {
            synchronized (this) {
                final RegistryObject<Item> item = Item.REGISTRY.get(getIdentifier());
                if (item.isPresent()) cachedItem = item.get();
            }
            hasItemCache.set(true);
        }
        return cachedItem;
    }
}
