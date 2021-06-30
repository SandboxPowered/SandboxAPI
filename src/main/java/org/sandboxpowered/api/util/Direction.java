package org.sandboxpowered.api.util;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import org.joml.Vector3i;
import org.joml.Vector3ic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public enum Direction implements StringSerializable {
    DOWN(0, 1, -1, "down", AxisDirection.NEGATIVE, Axis.Y, new Vector3i(0, -1, 0)),
    UP(1, 0, -1, "up", AxisDirection.POSITIVE, Axis.Y, new Vector3i(0, 1, 0)),
    NORTH(2, 3, 2, "north", AxisDirection.NEGATIVE, Axis.Z, new Vector3i(0, 0, -1)),
    SOUTH(3, 2, 0, "south", AxisDirection.POSITIVE, Axis.Z, new Vector3i(0, 0, 1)),
    WEST(4, 5, 1, "west", AxisDirection.NEGATIVE, Axis.X, new Vector3i(-1, 0, 0)),
    EAST(5, 4, 3, "east", AxisDirection.POSITIVE, Axis.X, new Vector3i(1, 0, 0));

    protected static final Direction[] ALL = values();
    protected static final Map<String, Direction> NAME_MAP = ImmutableMap.copyOf(Arrays.stream(ALL).collect(Collectors.toMap(Direction::getName, Function.identity())));
    protected static final Direction[] ID_TO_DIRECTION = Arrays.stream(ALL).sorted(Comparator.comparingInt(dir -> dir.id)).toArray(Direction[]::new);
    protected static final Direction[] HORIZONTAL = Arrays.stream(ALL).filter(dir -> dir.getAxis().isHorizontal()).sorted(Comparator.comparingInt(dir -> dir.horizontalId)).toArray(Direction[]::new);

    private final int id;
    private final int invertedId;
    private final int horizontalId;
    private final String name;
    private final Axis axis;
    private final AxisDirection axisDirection;
    private final Vector3i vector;

    Direction(int id, int invertedId, int horizontalId, String name, AxisDirection axisDirection, Axis axis, Vector3i vector) {
        this.id = id;
        this.invertedId = invertedId;
        this.horizontalId = horizontalId;
        this.name = name;
        this.axis = axis;
        this.axisDirection = axisDirection;
        this.vector = vector;
    }

    public static Direction byId(@Range(from = 0, to = 5) int index) {
        return ID_TO_DIRECTION[Math.abs(index % ID_TO_DIRECTION.length)];
    }

    public static Direction fromHorizontal(@Range(from = -1, to = 3) int horizontalIndex) {
        return HORIZONTAL[Math.abs(horizontalIndex % HORIZONTAL.length)];
    }

    @Range(from = 0, to = 5)
    public int getId() {
        return this.id;
    }

    @Range(from = -1, to = 3)
    public int getHorizontalId() {
        return this.horizontalId;
    }

    public AxisDirection getAxisDirection() {
        return this.axisDirection;
    }

    public Direction getOppositeDirection() {
        return byId(this.invertedId);
    }

    @Range(from = -1, to = 1)
    public int getOffsetX() {
        return vector.x;
    }

    @Range(from = -1, to = 1)
    public int getOffsetY() {
        return vector.y;
    }

    @Range(from = -1, to = 1)
    public int getOffsetZ() {
        return vector.z;
    }

    public Vector3ic getVector() {
        return vector;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Axis getAxis() {
        return this.axis;
    }

    public enum Type implements Predicate<Direction>, Iterable<Direction> {
        HORIZONTAL(new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST}),
        VERTICAL(new Direction[]{Direction.UP, Direction.DOWN});

        private final Direction[] facingArray;

        Type(Direction[] directions) {
            this.facingArray = directions;
        }

        @Override
        public boolean test(@Nullable Direction direction) {
            return direction != null && direction.getAxis().getType() == this;
        }

        @Override
        public Iterator<Direction> iterator() {
            return Iterators.forArray(facingArray);
        }
    }

    public enum AxisDirection {
        POSITIVE(1, "Towards positive"),
        NEGATIVE(-1, "Towards negative");

        private final int offset;
        private final String description;

        AxisDirection(int offset, String description) {
            this.offset = offset;
            this.description = description;
        }

        @Range(from = -1, to = 1)
        public int offset() {
            return this.offset;
        }

        @Override
        public String toString() {
            return this.description;
        }
    }

    public enum Axis implements Predicate<Direction> {
        X("x"),
        Y("y"),
        Z("z");

        private final String name;

        Axis(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public boolean isVertical() {
            return this == Y;
        }

        public boolean isHorizontal() {
            return this != Y;
        }

        public String toString() {
            return this.name;
        }

        @Override
        public boolean test(@Nullable Direction direction) {
            return direction != null && direction.getAxis() == this;
        }

        public Type getType() {
            return switch (this) {
                case X, Z -> Type.HORIZONTAL;
                case Y -> Type.VERTICAL;
            };
        }
    }
}
