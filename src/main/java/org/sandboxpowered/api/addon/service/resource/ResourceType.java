package org.sandboxpowered.api.addon.service.resource;

import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.content.item.ItemStack;
import org.sandboxpowered.api.registry.RegistryEntry;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;

public final class ResourceType<C extends RegistryEntry<C>> {
    private static final Pattern VALID_NAME = Pattern.compile("[^a-z_]");
    private static final Map<String, ResourceType<?>> TYPES = new TreeMap<>();
    private final String id;
    private final Function<ResourceMaterial, C> defaultCreator;
    private final Function<C, ItemStack> stackFunction;

    private ResourceType(@NotNull String id, Function<ResourceMaterial, C> defaultCreator, Function<C, ItemStack> stackFunction) {
        this.id = Objects.requireNonNull(id);
        this.defaultCreator = defaultCreator;
        this.stackFunction = stackFunction;
    }

    public static <C extends RegistryEntry<C>> ResourceType<C> of(String id, Function<ResourceMaterial, C> defaultCreator, Function<C, ItemStack> stackFunction) {
        if (VALID_NAME.matcher(id).matches()) {
            throw new IllegalArgumentException(String.format("Invalid ResourceType id '%s' doesnt match pattern \\%s\\", id, VALID_NAME));
        }
        return (ResourceType<C>) TYPES.computeIfAbsent(id, s -> new ResourceType<>(s, defaultCreator, stackFunction));
    }

    public static <X extends RegistryEntry<X>> ResourceType<X> find(String id) {
        return (ResourceType<X>) TYPES.get(id);
    }

    @Override
    public String toString() {
        return id;
    }

    public C createContent(ResourceMaterial material) {
        return defaultCreator.apply(material);
    }

    public ItemStack createItemStack(C c) {
        return stackFunction.apply(c);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ResourceType && id.equals(((ResourceType<?>) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}