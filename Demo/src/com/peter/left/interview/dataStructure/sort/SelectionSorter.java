package com.peter.left.interview.dataStructure.sort;

import java.util.List;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Lists;

/**
 * Sorter to use selection sort.
 *
 * <p>
 * Selection sort is to repeat putting every item in its proper position.
 * Min value in unsorted subset.
 * </p>
 * 
 * @param <E>
 */
public class SelectionSorter<E extends Comparable<E>> implements Sorter<E> 
{
    private <T> void swap(final List<T> list, final int i, final int j)
    {
        if (i != j)
        {
            final T temp = list.get(i);
    
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
    
    private <T extends E> int getMinIndex(final List<T> list, final int startPos)
    {
        Validate.notNull(list.get(startPos), "%dth item must not be null", startPos);

        int minIndex = startPos;
        T minValue = list.get(minIndex);

        for (int i = startPos + 1; i < list.size(); ++i)
        {
            if (minValue.compareTo(list.get(i)) > 0)
            {
                minIndex = i;
                minValue = list.get(i);
            }
        }
        
        return minIndex;
    }
    
    @Override
    public List<E> sort(final List<? extends E> list)
    {
        final List<E> result = Lists.newLinkedList(list);
        
        for (int i = 0; i < list.size(); ++i)
        {
            final int minIndex = getMinIndex(result, i);
            
            swap(result, i, minIndex);
        }
        
        return result;
    }
}
