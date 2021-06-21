package org.sandboxpowered.api.addon.service.resource;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.RegistryEntry;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;

public record ResourceType<C extends RegistryEntry<C>>(String id, Function<ResourceMaterial, C> defaultCreator,
                                                       Function<C, ItemStack> stackFunction) {
    private static final Pattern VALID_NAME = Pattern.compile("[^a-z_]");
    private static final Map<String, ResourceType<?>> TYPES = new TreeMap<>();

    public ResourceType {
        if (VALID_NAME.matcher(id).matches()) {
            throw new IllegalArgumentException(String.format("Type id must be lowercase got '%s'", id));
        }
        TYPES.put(id, this);
    }

    @Nullable
    public static <X extends RegistryEntry<X>> ResourceType<X> find(String id) {
        return (ResourceType<X>) TYPES.get(id);
    }

    public C createContent(ResourceMaterial material) {
        return defaultCreator.apply(material);
    }

    public ItemStack createItemStack(C c) {
        return stackFunction.apply(c);
    }
}