package org.sandboxpowered.api.block;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.registry.RegistryObject;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractBlock implements Block {
    private final AtomicReference<Item> cachedItem = new AtomicReference<>();

    @Override
    @Nullable
    public Item asItem() {
        synchronized (cachedItem) {
            if (cachedItem.get() == null) {
                final RegistryObject<Item> item = Item.REGISTRY.get(getIdentifier());
                if (item.isPresent()) cachedItem.set(cachedItem.get());
            }
            return cachedItem.get();
        }
    }
}