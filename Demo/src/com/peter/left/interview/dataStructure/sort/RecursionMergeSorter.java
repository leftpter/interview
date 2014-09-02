package com.peter.left.interview.dataStructure.sort;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Sorter use merge sort.
 *
 * <p>
 * Merge sort is an algorithm which merge two sorted lists into a sorted list.
 * Note: A singleton list is a sorted list. So recursively split list until
 * every sublist is a sorted list (singleton list). Then merge them together.
 * </p>
 *
 * @param <E>
 */
public class RecursionMergeSorter<E extends Comparable<E>> implements Sorter<E>
{
    private <T extends E> void mergeTwoSortedPart(final List<T> list,
            final int startPos, final int endPos, final int middlePos)
    {
        final int size = endPos - startPos;
        final List<T> temp = Lists.newArrayListWithCapacity(size);
        
        int left = startPos;
        int right = middlePos;
        
        for (int i = 0; i < size; ++i)
        {
            if ((right >= endPos) ||
                    (left < middlePos && list.get(left).compareTo(list.get(right)) <= 0))
            {
                temp.add(list.get(left++));
            }
            else
            {
                temp.add(list.get(right++));
            }
        }
        
        Collections.copy(list.subList(startPos, endPos), temp);
    }
    
    private void splitMergeSort(final List<? extends E> list,
            final int startPos, final int endPos)
    {
        if (startPos + 1 < endPos)
        {
            final int middlePos = (startPos + endPos) / 2;
            
            splitMergeSort(list, startPos, middlePos);
            splitMergeSort(list, middlePos, endPos);
            
            mergeTwoSortedPart(list, startPos, endPos, middlePos);
        }
    }
    
    @Override
    public List<E> sort(final List<? extends E> list)
    {
        final List<E> result = Lists.newArrayList(list);
        
        splitMergeSort(result, 0, result.size());
        
        return result;
    }
}
