package com.peter.left.interview.dataStructure.heap;

/**
 * Interface of the min heap.
 * 
 * <p>
 * A heap is a tree data structure, the root of the heap is least
 * element according to elements' natural order.
 * </p>
 *
 * @param <E> type of elements held in the heap.
 */
public interface Heap<E extends Comparable<E>> extends Iterable<E>
{
    /**
     * Return {@code true} if the heap contains no element.
     * 
     * @return {@code true} if the heap contains no element,
     *         {@code false} if the heap contains any element.
     */
    boolean isEmpty();
    
    /**
     * Retrieve and remove the head of the heap.
     * 
     * @return head of the heap.
     * @throws NoSuchElementException - the heap is empty.
     */
    E pop();
    
    /**
     * Insert the specified element into the heap.
     * 
     * @param element Element need to be inserted.
     * @throws IllegalStateException (optional) - heap with fixed size is full.
     */
    void push(E element);
    
    /**
     * Retrieve, but does not remove the head of the heap.
     * 
     * @return the head of the heap.
     * @throws NoSuchElementException - the heap is empty.
     */
    E peak();
    
    /**
     * Clear all elements in the heap.
     */
    void clear();
}
