package org.sandboxpowered.api.addon.service.resource;

import java.util.regex.Pattern;

public record ResourceMaterial(String id) {
    private static final Pattern VALID_NAME = Pattern.compile("[^a-z_]");

    public ResourceMaterial {
        if (VALID_NAME.matcher(id).matches()) {
            throw new IllegalArgumentException(String.format("Material id must be lowercase got '%s'", id));
        }
    }
}