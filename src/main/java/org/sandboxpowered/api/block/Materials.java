package org.sandboxpowered.api.block;

import org.sandboxpowered.api.Sandbox;

@SuppressWarnings("unused")
public final class Materials {
    private Materials() {
    }

    public static final Material AIR = of("air");
    /**
     * Structure void block.
     */
    public static final Material STRUCTURE_VOID = of("structure_void");
    /**
     * The various portal blocks.
     */
    public static final Material PORTAL = of("portal");
    public static final Material CARPET = of("carpet");
    /**
     * Plants such as flowers and crops
     */
    public static final Material PLANT = of("plant");
    /**
     * Underwater plants without the replaceable property.
     */
    public static final Material UNDERWATER_PLANT = of("underwater_plant");
    public static final Material REPLACEABLE_PLANT = of("replaceable_plant");
    /**
     * Crimson and warped roots, as well as Nether sprouts.
     */
    public static final Material NETHER_SHOOTS = of("nether_shoots");
    public static final Material REPLACEABLE_UNDERWATER_PLANT = of("replaceable_underwater_plant");
    public static final Material WATER = of("water");
    public static final Material BUBBLE_COLUMN = of("bubble_column");
    public static final Material LAVA = of("lava");
    /**
     * Non-full blocks of snow. Has the replaceable property.
     */
    public static final Material SNOW_LAYER = of("snow_layer");
    public static final Material FIRE = of("fire");
    /**
     * Decoration blocks such as redstone components, torches, flower pots, rails, buttons, and skulls.
     */
    public static final Material DECORATION = of("decoration");
    public static final Material COBWEB = of("cobweb");
    public static final Material SCULK = of("sculk");
    public static final Material REDSTONE_LAMP = of("redstone_lamp");
    /**
     * Blocks that come from mobs such as honey, slime, or infested blocks. Includes clay but not bone blocks.
     */
    public static final Material ORGANIC_PRODUCT = of("organic_product");
    /**
     * The top layer of soil. Path, dirt, podzol, soul soil, farmland and similar.
     */
    public static final Material SOIL = of("soil");
    /**
     * Organic blocks that are solid, including hay, target, and grass blocks.
     */
    public static final Material SOLID_ORGANIC = of("solid_organic");
    /**
     * A material or structure formed from a loosely compacted mass of fragments or particles.
     */
    public static final Material AGGREGATE = of("aggregate");
    public static final Material SPONGE = of("sponge");
    public static final Material SHULKER_BOX = of("shulker_box");
    /**
     * Wood logs, and things crafted from them.
     */
    public static final Material WOOD = of("wood");
    /**
     * Blocks crafted from Nether stems and hyphae.
     */
    public static final Material NETHER_WOOD = of("nether_wood");
    public static final Material BAMBOO_SAPLING = of("bamboo_sapling");
    public static final Material BAMBOO = of("bamboo");
    /**
     * Wool and bed blocks.
     */
    public static final Material WOOL = of("wool");
    public static final Material TNT = of("tnt");
    public static final Material LEAVES = of("leaves");
    /**
     * Glass and glass-like blocks (includes sea lanterns and conduits).
     */
    public static final Material GLASS = of("glass");
    /**
     * Ice that can melt. See {@link #DENSE_ICE} for unmeltable ice.
     */
    public static final Material ICE = of("ice");
    /**
     * Ice blocks that do not melt. See {@link #ICE} for meltable ice.
     */
    public static final Material DENSE_ICE = of("dense_ice");
    public static final Material CACTUS = of("cactus");
    /**
     * Blocks that are stone or made from it, and generally prefer to be broken by a pickaxe.
     */
    public static final Material STONE = of("stone");
    /**
     * Blocks metallic in nature, such as cauldrons, bells, iron doors, and iron trapdoors. It also includes non-obvious blocks such as brewing stands and compressed ore blocks, including diamond, redstone, and lapis blocks.
     */
    public static final Material METAL = of("metal");
    /**
     * Full sized snow blocks.
     */
    public static final Material SNOW_BLOCK = of("snow_block");
    /**
     * Blocks that can repair tools, including grindstone and anvils.
     */
    public static final Material REPAIR_STATION = of("repair_station");
    public static final Material BARRIER = of("barrier");
    public static final Material PISTON = of("piston");
    /**
     * Full sized moss blocks.
     */
    public static final Material MOSS_BLOCK = of("moss_block");
    /**
     * Gourds. Includes the carved pumpkin and jack o' lantern.
     */
    public static final Material GOURD = of("gourd");
    /**
     * Egg blocks, such as dragon and turtle eggs.
     */
    public static final Material EGG = of("egg");
    /**
     * Placable food such as cake.
     */
    public static final Material FOOD = of("food");
    public static final Material AMETHYST = of("amethyst");
    public static final Material POWDER_SNOW = of("powder_snow");

    private static Material of(String material) {
        return Sandbox.getFactoryProvider().provide(Material.MaterialFactory.class).fromVanilla(material);
    }
}
