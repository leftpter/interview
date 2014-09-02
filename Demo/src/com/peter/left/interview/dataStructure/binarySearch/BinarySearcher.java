package com.peter.left.interview.dataStructure.binarySearch;

/**
 * Interface for binary search.
 *
 * @param <E> type of elements held in the array.
 */
public interface BinarySearcher<E extends Comparable<E>>
{
    /**
     * Search a specified element in an sorted array.
     * @param elements sorted array.
     * @param element element need to be searched.
     * @return {@code -1} - if specified element is not in the array.
     *         index - the index of specified element in the array.
     */
    int search(E[] elements, E element);
}
