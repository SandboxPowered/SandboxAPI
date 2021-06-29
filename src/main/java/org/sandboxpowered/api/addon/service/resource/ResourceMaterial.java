package org.sandboxpowered.api.addon.service.resource;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Pattern;

public final class ResourceMaterial {
    private static final Pattern VALID_NAME = Pattern.compile("[^a-z_]");
    private static final Map<String, ResourceMaterial> MATERIALS = new TreeMap<>();
    private final String id;

    private ResourceMaterial(@NotNull String id) {
        this.id = Objects.requireNonNull(id);
    }

    public static ResourceMaterial of(String id) {
        if (VALID_NAME.matcher(id).matches()) {
            throw new IllegalArgumentException(String.format("Invalid ResourceMaterial id '%s' doesnt match pattern \\%s\\", id, VALID_NAME));
        }
        return MATERIALS.computeIfAbsent(id, ResourceMaterial::new);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ResourceMaterial && id.equals(((ResourceMaterial) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}