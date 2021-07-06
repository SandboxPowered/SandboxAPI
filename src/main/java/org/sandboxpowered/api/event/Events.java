package org.sandboxpowered.api.event;

import org.sandboxpowered.api.content.entity.Entity;
import org.sandboxpowered.api.content.item.Hand;
import org.sandboxpowered.api.content.item.ItemStack;
import org.sandboxpowered.api.util.ActionResult;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.state.BlockState;

public class Events {
    public static final Event<BreakEvent> BREAK_BLOCK = EventFactory.createEventHandler();
    public static final Event<PlaceEvent> PLACE_BLOCK = EventFactory.createEventHandler();
    public static final Event<InteractEvent> INTERACT_BLOCK = EventFactory.createEventHandler();

    public interface BreakEvent {
        void on(World world, Position position, BlockState state, Entity player, ItemStack tool);
    }

    public interface PlaceEvent {
        BlockState on(World world, Position position, BlockState state, Entity player, ItemStack stack);
    }

    public interface InteractEvent {
        ActionResult on(World world, Position position, BlockState state, Entity player, Hand hand, ItemStack stack);
    }
}
