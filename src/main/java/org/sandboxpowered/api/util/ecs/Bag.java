package org.sandboxpowered.api.util.ecs;

import java.util.Comparator;

/**
 * Collection type a bit like ArrayList but does not preserve the order of its
 * entities, speedwise it is very good, especially suited for games.
 *
 * @param <E> object type this bag holds
 */
public interface Bag<E> extends ImmutableBag<E> {

    /**
     * Removes the element at the specified position in this Bag.
     * <p>
     * It does this by overwriting it was last element then removing last
     * element
     * </p>
     *
     * @param index the index of element to be removed
     *
     * @return element that was removed from the Bag
     *
     * @throws ArrayIndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    E remove(int index);

    /**
     * Sorts the bag using a {@link Comparator}.
     */
    void sort(Comparator<E> comparator);

    /**
     * Remove and return the last object in the bag.
     *
     * @return the last object in the bag, null if empty
     */
    E removeLast();

    /**
     * Removes the first occurrence of the specified element from this Bag, if
     * it is present.
     * <p>
     * If the Bag does not contain the element, it is unchanged. It does this
     * by overwriting it was last element then removing last element
     * </p>
     *
     * @param element element to be removed from this list, if present
     *
     * @return {@code true} if this list contained the specified element
     */
    boolean remove(E element);

    /**
     * Removes from this Bag all of its elements that are contained in the
     * specified Bag.
     *
     * @param bag Bag containing elements to be removed from this Bag
     *
     * @return {@code true} if this Bag changed as a result of the call
     */
    boolean removeAll(ImmutableBag<E> bag);

    /**
     * Adds the specified element to the end of this bag.
     * <p>
     * If required, it also increases the capacity of the bag.
     * </p>
     *
     * @param element element to be added to this list
     */
    void add(E element);

    /**
     * Add all items into this bag.
     *
     * @param bag bag with items to add
     */
    void addAll(ImmutableBag<E> bag);

    /**
     * Set element at specified index in the bag.
     *
     * @param index position of element
     * @param element the element
     */
    void set(int index, E element);

    /**
     * Removes all of the elements from this bag.
     * <p>
     * The bag will be empty after this call returns.
     * </p>
     */
    void clear();
}
