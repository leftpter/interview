package com.peter.left.interview.dataStructure.sort;

import java.util.List;

/**
 * Interface to sort a given list.
 * 
 * @param <E> type of elements in the list.
 */
public interface Sorter<E extends Comparable<E>>
{
    List<E> sort(List<? extends E> list);
}
