package org.sandboxpowered.api.content.entity.component;

import org.sandboxpowered.api.content.entity.ItemSlot;
import org.sandboxpowered.api.content.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class InventoryComponent implements PooledComponent {
    private final Map<ItemSlot, ItemStack> map = new HashMap<>();

    public ItemStack get(ItemSlot slot) {
        return map.getOrDefault(slot, ItemStack.empty());
    }

    public void set(ItemSlot slot, ItemStack stack) {
        map.put(slot, stack);
    }

    @Override
    public void reset() {
        map.clear();
    }
}
