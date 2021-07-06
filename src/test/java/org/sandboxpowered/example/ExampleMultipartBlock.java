package org.sandboxpowered.example;

import org.sandboxpowered.api.content.block.AbstractBlock;
import org.sandboxpowered.api.content.block.Block;
import org.sandboxpowered.api.content.block.MultipartSlot;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.shape.Shape;
import org.sandboxpowered.api.util.shape.ShapeCombination;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.WorldReader;
import org.sandboxpowered.api.world.state.BlockState;
import org.sandboxpowered.api.world.state.StateProvider;
import org.sandboxpowered.api.world.state.property.BooleanProperty;

import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;

import static org.sandboxpowered.api.util.multipart.MultipartUtil.testShapeOcclusion;

public class ExampleMultipartBlock extends AbstractBlock {
    private static final Map<Direction, BooleanProperty> CONNECTION_PROPERTIES = new EnumMap<>(Direction.class);

    private static final Shape CENTER_SHAPE = Shape.createCuboid(4, 4, 4, 12, 12, 12);
    private static final Map<Direction, Shape> DIRECTION_SHAPE_MAP = new EnumMap<>(Direction.class);
    private static final Map<BlockState, Shape> SHAPE_CACHE = new IdentityHashMap<>();

    static {
        for (Direction direction : Direction.values()) {
            CONNECTION_PROPERTIES.put(direction, BooleanProperty.of(direction.getName()));
        }

        DIRECTION_SHAPE_MAP.put(Direction.DOWN, Shape.createCuboid(4, 0, 4, 12, 4, 12));
        DIRECTION_SHAPE_MAP.put(Direction.UP, Shape.createCuboid(4, 12, 4, 12, 16, 12));
        DIRECTION_SHAPE_MAP.put(Direction.NORTH, Shape.createCuboid(4, 4, 0, 12, 12, 4));
        DIRECTION_SHAPE_MAP.put(Direction.SOUTH, Shape.createCuboid(4, 4, 12, 12, 12, 16));
        DIRECTION_SHAPE_MAP.put(Direction.WEST, Shape.createCuboid(0, 4, 4, 4, 12, 12));
        DIRECTION_SHAPE_MAP.put(Direction.EAST, Shape.createCuboid(12, 4, 4, 16, 12, 12));
    }

    private static final MultipartSlot SLOT = MultipartSlot.get("example", "pipe");

    public ExampleMultipartBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MultipartSlot getSlot(BlockState state) {
        return SLOT;
    }

    @Override
    protected BlockState createDefaultState(BlockState base) {
        return super.createDefaultState(base);
    }

    @Override
    public Shape getShape(WorldReader reader, Position position, BlockState state) {
        return SHAPE_CACHE.computeIfAbsent(state, ExampleMultipartBlock::computeShape);
    }

    @Override
    public Shape getOcclusionShape(WorldReader reader, Position position, BlockState state) {
        return CENTER_SHAPE;
    }

    @Override
    public BlockState updateOnNeighborChanged(World world, Position position, Direction direction, BlockState state, Block other, Position otherPosition) {
        BooleanProperty property = CONNECTION_PROPERTIES.get(direction);
        if (world.getBlockState(otherPosition, SLOT).getBlock() == this) {
            Shape shape = DIRECTION_SHAPE_MAP.get(direction);
            Shape neighborShape = DIRECTION_SHAPE_MAP.get(direction.getOppositeDirection());
            if (!testShapeOcclusion(world, position, shape) && !testShapeOcclusion(world, otherPosition, neighborShape)) {
                return state.with(property, true);
            }
        }
        return state.with(property, false);
    }

    @Override
    protected void appendProperties(StateProvider.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        CONNECTION_PROPERTIES.values().forEach(builder::add);
    }

    private static Shape computeShape(BlockState state) {
        Shape shape = CENTER_SHAPE;
        for (Direction direction : Direction.values()) {
            if (state.get(CONNECTION_PROPERTIES.get(direction))) {
                shape = shape.combine(DIRECTION_SHAPE_MAP.get(direction), ShapeCombination.OR);
            }
        }
        return shape;
    }
}
