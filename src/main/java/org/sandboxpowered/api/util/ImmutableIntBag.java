package org.sandboxpowered.api.util;

import it.unimi.dsi.fastutil.ints.IntIterable;

/**
 * A non-modifiable bag.
 * <p>
 * A bag is a set that can also hold duplicates. Also known as multiset.
 * </p>
 *
 * @param <E> object type this bag holds
 *
 * @see Bag
 */
public interface ImmutableIntBag extends IntIterable {
    /**
     * Returns the element at the specified position in Bag.
     *
     * @param index index of the element to return
     *
     * @return the element at the specified position in bag
     *
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    int get(int index);

    /**
     * Returns the number of elements in this bag.
     *
     * @return the number of elements in this bag
     */
    int size();

    /**
     * Returns true if this bag contains no elements.
     *
     * @return true if this bag contains no elements
     */
    boolean isEmpty();

    /**
     * Check if bag contains this element.
     *
     * @return true if the bag contains this element
     */
    boolean contains(int element);

    /**
     * Checks if the internal storage supports this index.
     *
     * @param index index to check
     *
     * @return {@code true} if the index is within bounds
     */
    boolean isIndexWithinBounds(int index);
}
