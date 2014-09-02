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
public class IterativeMergeSorter<E extends Comparable<E>> implements Sorter<E>
{
    private <T extends E> void mergeTwoSortedPart(final List<T> list,
            final int startPos, final int endPos, final int middlePos)
    {
        final int size = endPos - startPos;
        
        if (size > 1)
        {
            final List<T> temp = Lists.newArrayListWithCapacity(size);
            
            int left = startPos;
            int right = middlePos;
            
            for (int i = 0; i < size; ++i)
            {
                if ((right >= endPos) ||
                        ((left < middlePos) && (list.get(left).compareTo(list.get(right)) <= 0)))
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
    }
    
    @Override
    public List<E> sort(final List<? extends E> list)
    {
        final List<E> result = Lists.newArrayList(list);
        
        int interval;
        for (interval = 2; interval < result.size(); interval <<= 1)
        {
            int i;
            for (i = 0; i < result.size() / interval; ++i)
            {
                final int startPos = interval * i;
                final int endPos = interval * (i + 1);
                
                mergeTwoSortedPart(result, startPos, endPos, (startPos + endPos) / 2);
            }
            
            // There are rest item.
            if (result.size() % interval != 0)
            {
                final int startPos = i * interval;
                final int endPos = result.size();
                final int middlePos = (startPos + startPos + interval) / 2;
                
                if (middlePos < endPos)
                {
                    mergeTwoSortedPart(result, startPos, endPos, (startPos + endPos) / 2);
                }
            }
        }
        
        mergeTwoSortedPart(result, 0, result.size(), interval / 2);
        
        return result;
    }
}
