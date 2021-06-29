package org.sandboxpowered.api.item.attribute;

import org.sandboxpowered.api.Sandbox;

public class Attributes {
    public static final Attribute MAX_HEALTH = get("generic.max_health");
    public static final Attribute FOLLOW_RANGE = get("generic.follow_range");
    public static final Attribute KNOCKBACK_RESISTANCE = get("generic.knockback_resistance");
    public static final Attribute MOVEMENT_SPEED = get("generic.movement_speed");
    public static final Attribute FLYING_SPEED = get("generic.flying_speed");
    public static final Attribute ATTACK_DAMAGE = get("generic.attack_damage");
    public static final Attribute ATTACK_KNOCKBACK = get("generic.attack_knockback");
    public static final Attribute ATTACK_SPEED = get("generic.attack_speed");
    public static final Attribute ARMOR = get("generic.armor");
    public static final Attribute ARMOR_TOUGHNESS = get("generic.armor_toughness");
    public static final Attribute LUCK = get("generic.luck");
    public static final Attribute SPAWN_REINFORCEMENTS_CHANCE = get("zombie.spawn_reinforcements");
    public static final Attribute JUMP_STRENGTH = get("horse.jump_strength");

    private static Attribute get(String id) {
        return Sandbox.getFactoryProvider().provide(BuiltinAttributeFactory.class).from(id);
    }

    public interface BuiltinAttributeFactory {
        Attribute from(String id);
    }
}
