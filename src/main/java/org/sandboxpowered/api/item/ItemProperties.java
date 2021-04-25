package org.sandboxpowered.api.item;

public interface ItemProperties {

    ItemProperties setStackSize(int stackSize);

    ItemProperties setMaxDamage(int maxDamage);

    ItemProperties setRecipeRemainder(Item recipeRemainder);
}
