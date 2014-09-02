package com.peter.left.interview.dataStructure.sort;

import java.util.List;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Lists;

/**
 * Sorter to use insertion sort.
 * 
 * <p>
 * Insertion sort is an algorithm repeat insert the new element into sorted
 * list.
 * </p>
 *
 * @param <E> type of element in the list.
 */
public class InsertionSorter<E extends Comparable<E>> implements Sorter<E>
{
    private <T extends E> void insertElementToSortedList(final List<T> list, final T element)
    {
        Validate.notNull(element, "element must not be null");
        int i;
        for (i = 0; i < list.size(); ++i)
        {
            if (element.compareTo(list.get(i)) <= 0)
            {
                break;
            }
        }
        
        list.add(i, element);
    }
    
    @Override
    public List<E> sort(final List<? extends E> list)
    {
        Validate.notNull(list, "list must not be null");

        final List<E> result = Lists.newLinkedList();
        
        if (!list.isEmpty())
        {
            result.add(list.get(0));
            
            for (int i = 1; i < list.size(); ++i)
            {
                insertElementToSortedList(result, list.get(i));
            }
        }
        
        return result;
    }
}
