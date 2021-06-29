package org.sandboxpowered.api.block;

import org.jetbrains.annotations.Nullable;
import org.joml.Vector3fc;
import org.sandboxpowered.api.Sandbox;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.item.Hand;
import org.sandboxpowered.api.item.ItemProvider;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.item.tool.ToolType;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.registry.RegistryEntry;
import org.sandboxpowered.api.registry.RegistryFactory;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.InteractionResult;
import org.sandboxpowered.api.util.Mirror;
import org.sandboxpowered.api.util.Rotation;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.WorldReader;
import org.sandboxpowered.api.world.state.BlockState;
import org.sandboxpowered.api.world.state.StateProvider;

@SuppressWarnings("unused")
public interface Block extends RegistryEntry<Block>, ItemProvider {
    Registry<Block> REGISTRY = RegistryFactory.getRegistry(Block.class);

    default BlockState getDefaultState() {
        return getStateProvider().getBaseState();
    }

    StateProvider<Block, BlockState> getStateProvider();

    Properties getProperties();

    /**
     * Gets called when the block is placed
     */
    default void onBlockPlaced(World world, Position position, BlockState state, @Nullable Entity entity, ItemStack itemStack) {
    }

    /**
     * Gets called when the block is broken
     */
    default void onBlockBroken(World world, Position position, BlockState state) {
    }

    default BlockState rotate(BlockState state, Rotation rotation) {
        return state;
    }

    default BlockState mirror(BlockState state, Mirror mirror) {
        return state;
    }

    default boolean canReplace(BlockState state) {
        return getProperties().getMaterial().isReplaceable();
    }

    default boolean isAir(BlockState state) {
        return false;
    }

    default void onEntityWalk(World world, Position position, Entity entity) {

    }

    default boolean canEntitySpawnWithin() {
        return getProperties().getMaterial().isNonSolid() && !getProperties().getMaterial().isLiquid();
    }

    default ItemStack getPickStack(WorldReader reader, Position position, BlockState state) {
        return ItemStack.of(this);
    }

    /**
     * Gets called when the block is interacted with by a {@link Entity}
     *
     * @return The {@link InteractionResult} of the interaction
     */
    default InteractionResult onBlockUsed(World world, Position pos, BlockState state, Entity entity, Hand hand, Direction side, Vector3fc hit) {
        return InteractionResult.IGNORE;
    }

    /**
     * Gets called when the block is clicked by a {@link Entity}
     *
     * @return The {@link InteractionResult} of the interaction
     */
    default InteractionResult onBlockClicked(World world, Position pos, BlockState state, Entity entity) {
        return InteractionResult.IGNORE;
    }

    @Override
    default Registry<Block> getRegistry() {
        return REGISTRY;
    }

    interface Properties {
        Material getMaterial();

        ToolType getToolType();

        int getHarvestLevel();

        boolean doesRequireCorrectToolForDrops();

        float getHardness();

        float getResistance();

        static Properties.Builder builder(Material material) {
            return Sandbox.getFactoryProvider().provide(Properties.PropertiesFactory.class).createBuilder(material);
        }

        interface Builder {
            Builder setStrength(float hardness, float resistance);

            Builder setStrength(float strength);

            Builder setHarvestTool(ToolType type);

            Builder setHarvestLevel(int level);

            Builder requiresCorrectToolForDrops();

            Properties build();
        }

        interface PropertiesFactory {
            Properties.Builder createBuilder(Material material);
        }
    }
}
