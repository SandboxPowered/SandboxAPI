package org.sandboxpowered.api.world.state.property;

public abstract class AbstractProperty<T extends Comparable<T>> implements Property<T> {
    private final Class<T> type;
    private final String name;

    protected AbstractProperty(String name, Class<T> type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getPropertyName() {
        return name;
    }

    @Override
    public Class<T> getValueType() {
        return type;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof AbstractProperty)) {
            return false;
        } else {
            AbstractProperty<?> property = (AbstractProperty<?>) object;
            return this.type.equals(property.type) && this.name.equals(property.name);
        }
    }

    @Override
    public int hashCode() {
        return 31 * this.type.hashCode() + this.name.hashCode();
    }
}