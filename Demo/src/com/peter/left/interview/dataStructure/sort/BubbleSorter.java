package com.peter.left.interview.dataStructure.sort;

import java.util.List;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Lists;

/**
 * Sorter to use bubble sort.
 * 
 * <p>
 * Bubble sort is an algorithm to bubble up the lightest item to
 * the top. it repeat to swap two adjacent elements according to
 * natural order.
 * </p>
 *
 * @param <E>
 */
public class BubbleSorter<E extends Comparable<E>> implements Sorter<E>
{
    private <T> void swap(final List<T>list, final int i, final int j)
    {
        final T temp = list.get(i);
        
        list.set(i, list.get(j));
        
        list.set(j, temp);
    }
    
    @Override
    public List<E> sort(final List<? extends E> list)
    {
        Validate.notNull(list, "list must not be null");

        final List<E> result = Lists.newArrayList(list);
        
        for (int i = 0; i < result.size(); ++i)
        {
            int swapCount = 0;
            for (int j = result.size() - 1; j > i; --j)
            {
                if (result.get(j).compareTo(result.get(j - 1)) < 0)
                {
                    ++swapCount;
                    
                    swap(result, j, j - 1);
                }
            }
            
            if (0 == swapCount)
            {
                break;
            }
        }
        
        return result;
    }
}
