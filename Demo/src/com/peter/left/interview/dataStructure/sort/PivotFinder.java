package com.peter.left.interview.dataStructure.sort;

import java.util.List;

/**
 * Interface to find pivot for the quick sort.
 *
 * @param <E> type of the elements in the list need to be sorted.
 */
public interface PivotFinder<E extends Comparable<E>>
{
    /**
     * Find the index of pivot in the given list.
     * @param list List of elements where the pivot come from.
     * @param startPos Start position of the elements.
     * @param endPos End position of the elements.
     * @return Index of pivot in the list. -1 if the list already sorted.
     */
    int find(List<E> list, int startPos, int endPos);
}
