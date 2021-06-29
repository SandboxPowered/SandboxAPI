package org.sandboxpowered.api.addon.service.resource;

import org.sandboxpowered.api.block.AbstractBlock;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.block.Materials;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.item.tool.ToolType;
import org.sandboxpowered.api.registry.RegistryEntry;

import java.util.function.Function;

public final class ResourceConstants {

    private static final Function<ResourceMaterial, Item> ITEM_CREATOR = material -> Item.create(Item.Properties.builder().build());

    /* Vanilla Materials */

    public static final ResourceMaterial WOOD = material("wood");
    public static final ResourceMaterial STONE = material("stone");
    public static final ResourceMaterial COAL = material("coal");
    public static final ResourceMaterial IRON = material("iron");
    public static final ResourceMaterial COPPER = material("copper");
    public static final ResourceMaterial GOLD = material("gold");
    public static final ResourceMaterial LAPIS = material("lapis");
    public static final ResourceMaterial REDSTONE = material("redstone");
    public static final ResourceMaterial DIAMOND = material("diamond");
    public static final ResourceMaterial EMERALD = material("emerald");
    public static final ResourceMaterial OBSIDIAN = material("obsidian");
    public static final ResourceMaterial AMETHYST = material("amethyst");

    public static final ResourceMaterial QUARTZ = material("quartz");
    public static final ResourceMaterial GLOWSTONE = material("glowstone");
    public static final ResourceMaterial NETHERITE = material("netherite");

    /* Vanilla Types */

    public static final ResourceType<Item> INGOT = item("ingot");
    public static final ResourceType<Item> DUST = item("dust");
    public static final ResourceType<Item> NUGGET = item("nugget");
    public static final ResourceType<Item> GEM = item("gem");
    public static final ResourceType<Item> SCRAP = item("scrap");
    public static final ResourceType<Block> NETHER_ORE = ResourceType.of("nether_ore", m -> new AbstractBlock(Block.Properties.builder(Materials.STONE).setStrength(3).requiresCorrectToolForDrops().setHarvestTool(ToolType.PICKAXE).setHarvestLevel(1).build()), ItemStack::of);
    public static final ResourceType<Block> ORE = ResourceType.of("ore", m -> new AbstractBlock(Block.Properties.builder(Materials.STONE).setStrength(3).requiresCorrectToolForDrops().setHarvestTool(ToolType.PICKAXE).setHarvestLevel(1).build()), ItemStack::of);
    public static final ResourceType<Block> BLOCK = ResourceType.of("block", m -> new AbstractBlock(Block.Properties.builder(Materials.METAL).requiresCorrectToolForDrops().setStrength(5.0F, 6.0F).build()), ItemStack::of);

    /* Common Modded Constants */

    public static final ResourceMaterial TIN = material("tin");
    public static final ResourceMaterial SILVER = material("silver");
    public static final ResourceMaterial LEAD = material("lead");

    public static final ResourceType<Item> GEAR = item("gear");
    public static final ResourceType<Item> PLATE = item("plate");

    public static ResourceMaterial material(String name) {
        return ResourceMaterial.of(name);
    }

    public static <C extends RegistryEntry<C>> ResourceType<C> type(String name, Function<ResourceMaterial, C> defaultCreator, Function<C, ItemStack> stackFunction) {
        return ResourceType.of(name, defaultCreator, stackFunction);
    }

    public static ResourceType<Item> item(String name) {
        return ResourceType.of(name, ITEM_CREATOR, ItemStack::of);
    }
}