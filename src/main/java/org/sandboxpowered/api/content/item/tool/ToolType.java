package org.sandboxpowered.api.content.item.tool;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public final class ToolType {
    private static final Pattern VALID_NAME = Pattern.compile("[^a-z_]");
    private static final Map<String, ToolType> VALUES = new TreeMap<>();
    public static final ToolType AXE = get("axe");
    public static final ToolType HOE = get("hoe");
    public static final ToolType PICKAXE = get("pickaxe");
    public static final ToolType SHOVEL = get("shovel");
    public static final ToolType STRIPPER = get("stripper");
    public static final ToolType PAVER = get("paver");
    private final String name;

    private ToolType(String name) {
        this.name = name;
    }

    public static ToolType get(String name) {
        return VALUES.computeIfAbsent(name, (k) -> {
            if (VALID_NAME.matcher(name).find()) {
                throw new IllegalArgumentException(String.format("Invalid ToolType name '%s' doesnt match pattern \\%s\\", name, VALID_NAME));
            } else {
                return new ToolType(name);
            }
        });
    }

    public String getName() {
        return name;
    }
}
