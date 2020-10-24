package org.sandboxpowered.api.resources;

import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.block.Blocks;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.Items;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.internal.Sandbox;

import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {
    private static final Map<String, Resource> TYPES = new HashMap<>();

    static {
        appendIron();
        appendGold();
        appendDiamond();
    }

    private ResourceManager() {
    }

    //TODO: put somewhere else? this gets called after all addons get initialized so we can do preferences properly
    public static void register() {
        TYPES.forEach((name, resource) -> {
            resource.forEachItem(type -> Item.REGISTRY.register(Identity.of("sandbox", type.getFullName(name)), resource.getItem(type).orElseThrow(() ->
                    new IllegalStateException("Item named " + type.getFullName(name) + " was in resource list but doesn't exist!"))));
            resource.forEachBlock(type -> Block.REGISTRY.register(Identity.of("sandbox", type.getFullName(name)), resource.getBlock(type).orElseThrow(() ->
                    new IllegalStateException("Block named " + type.getFullName(name) + " was in resource list but doesn't exist!"))));
            resource.forEachFluid(type -> Fluid.REGISTRY.register(Identity.of("sandbox", type.getFullName(name)), resource.getFluid(type).orElseThrow(() ->
                    new IllegalStateException("Fluid named" + type.getFullName(name) + " was in resource list but doesn't exist!"))));
        });
    }

    //TODO: put somewhere else? this is called to wipe existing resource types when you leave, and leaving the vanilla resource lists intact
    public static void deregister() {
        TYPES.clear();
        appendIron();
        appendGold();
        appendDiamond();
    }

    //TODO: any way to do this better than hardcoding?
    private static void appendIron() {
        Map<ResourceType, Item> ironItems = new HashMap<>();
        Map<ResourceType, Block> ironBlocks = new HashMap<>();
        ironItems.put(ResourceType.INGOT, Items.IRON_INGOT.get());
        ironItems.put(ResourceType.NUGGET, Items.IRON_NUGGET.get());
        ironItems.put(ResourceType.PICKAXE, Items.IRON_PICKAXE.get());
        ironItems.put(ResourceType.AXE, Items.IRON_AXE.get());
        ironItems.put(ResourceType.SHOVEL, Items.IRON_SHOVEL.get());
        ironItems.put(ResourceType.HOE, Items.IRON_HOE.get());
        ironItems.put(ResourceType.SWORD, Items.IRON_SWORD.get());
        ironItems.put(ResourceType.HELMET, Items.IRON_HELMET.get());
        ironItems.put(ResourceType.CHESTPLATE, Items.IRON_CHESTPLATE.get());
        ironItems.put(ResourceType.LEGGINGS, Items.IRON_LEGGINGS.get());
        ironItems.put(ResourceType.BOOTS, Items.IRON_BOOTS.get());
        ironItems.put(ResourceType.HORSE_ARMOR, Items.IRON_HORSE_ARMOR.get());
        ironBlocks.put(ResourceType.BLOCK, Blocks.IRON_BLOCK.get());
        ironBlocks.put(ResourceType.ORE, Blocks.IRON_ORE.get());
        TYPES.put("iron", new VanillaResource("iron", ironItems, ironBlocks));
    }

    //TODO: any way to do this better than hardcoding?
    private static void appendGold() {
        Map<ResourceType, Item> goldItems = new HashMap<>();
        Map<ResourceType, Block> goldBlocks = new HashMap<>();
        goldItems.put(ResourceType.INGOT, Items.GOLD_INGOT.get());
        goldItems.put(ResourceType.NUGGET, Items.GOLD_NUGGET.get());
        goldItems.put(ResourceType.PICKAXE, Items.GOLDEN_PICKAXE.get());
        goldItems.put(ResourceType.AXE, Items.GOLDEN_AXE.get());
        goldItems.put(ResourceType.SHOVEL, Items.GOLDEN_SHOVEL.get());
        goldItems.put(ResourceType.HOE, Items.GOLDEN_HOE.get());
        goldItems.put(ResourceType.SWORD, Items.GOLDEN_SWORD.get());
        goldItems.put(ResourceType.HELMET, Items.GOLDEN_HELMET.get());
        goldItems.put(ResourceType.CHESTPLATE, Items.GOLDEN_CHESTPLATE.get());
        goldItems.put(ResourceType.LEGGINGS, Items.GOLDEN_LEGGINGS.get());
        goldItems.put(ResourceType.BOOTS, Items.GOLDEN_BOOTS.get());
        goldItems.put(ResourceType.HORSE_ARMOR, Items.GOLDEN_HORSE_ARMOR.get());
        goldBlocks.put(ResourceType.BLOCK, Blocks.GOLD_BLOCK.get());
        goldBlocks.put(ResourceType.ORE, Blocks.GOLD_ORE.get());
        //TODO: nether gold ore
        TYPES.put("gold", new VanillaResource("gold", goldItems, goldBlocks));
    }

    //TODO: any way to do this better than hardcoding?
    private static void appendDiamond() {
        Map<ResourceType, Item> ironItems = new HashMap<>();
        Map<ResourceType, Block> ironBlocks = new HashMap<>();
        ironItems.put(ResourceType.BASE, Items.DIAMOND.get());
        ironItems.put(ResourceType.PICKAXE, Items.DIAMOND_PICKAXE.get());
        ironItems.put(ResourceType.AXE, Items.DIAMOND_AXE.get());
        ironItems.put(ResourceType.SHOVEL, Items.DIAMOND_SHOVEL.get());
        ironItems.put(ResourceType.HOE, Items.DIAMOND_HOE.get());
        ironItems.put(ResourceType.SWORD, Items.DIAMOND_SWORD.get());
        ironItems.put(ResourceType.HELMET, Items.DIAMOND_HELMET.get());
        ironItems.put(ResourceType.CHESTPLATE, Items.DIAMOND_CHESTPLATE.get());
        ironItems.put(ResourceType.LEGGINGS, Items.DIAMOND_LEGGINGS.get());
        ironItems.put(ResourceType.BOOTS, Items.DIAMOND_BOOTS.get());
        ironItems.put(ResourceType.HORSE_ARMOR, Items.DIAMOND_HORSE_ARMOR.get());
        ironBlocks.put(ResourceType.BLOCK, Blocks.DIAMOND_BLOCK.get());
        ironBlocks.put(ResourceType.ORE, Blocks.DIAMOND_ORE.get());
        TYPES.put("diamond", new VanillaResource("diamond", ironItems, ironBlocks));
    }
}
