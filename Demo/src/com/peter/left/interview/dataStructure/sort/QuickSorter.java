package com.peter.left.interview.dataStructure.sort;

import java.util.List;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Lists;

public class QuickSorter<E extends Comparable<E>> implements Sorter<E>
{
    private final PivotFinder<E> finder;
    
    public QuickSorter(final PivotFinder<E> finder)
    {
        Validate.notNull(finder, "finder must not be null");
        
        this.finder = finder;
    }
    
    private int findPivot(final List<E> list,
            final int startPos, final int endPos)
    {
        return finder.find(list, startPos, endPos);
    }
    
    private void swap(final List<E> list, final int i, final int j)
    {
        if (i != j)
        {
            final E temp = list.get(i);
            
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
    
    private void quickSort(final List<E> list, final int startPos, final int endPos)
    {
        if (startPos < endPos)
        {
            final int pivotIndex = findPivot(list, startPos, endPos);
            
            if (-1 != pivotIndex)
            {
                final E pivotValue = list.get(pivotIndex);
                
                int leftPos = startPos;
                int rightPos = endPos;
                
                while (leftPos <= rightPos)
                {
                    while (list.get(leftPos).compareTo(pivotValue) < 0)
                    {
                        ++leftPos;
                    }
                    
                    while (list.get(rightPos).compareTo(pivotValue) >= 0)
                    {
                        --rightPos;
                    }
                    
                    if (leftPos < rightPos)
                    {
                        swap(list, leftPos++, rightPos--);
                    }
                }
                
                quickSort(list, startPos, rightPos);
                quickSort(list, rightPos + 1, endPos);
            }
        }
    }
    
    @Override
    public List<E> sort(final List<? extends E> list)
    {
        final List<E> result = Lists.newArrayList(list);
        
        quickSort(result, 0, result.size() - 1);
        
        return result;
    }
}
