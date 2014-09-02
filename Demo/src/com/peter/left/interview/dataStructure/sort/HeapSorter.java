package com.peter.left.interview.dataStructure.sort;

import java.util.List;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Lists;
import com.peter.left.interview.dataStructure.heap.Heap;

public class HeapSorter<E extends Comparable<E>> implements Sorter<E>
{
    private final Heap<E> heap;
    
    public HeapSorter(final Heap<E> heap)
    {
        Validate.notNull(heap, "heap must not be null");
        
        this.heap = heap;
    }
    
    private <T extends E> void fillHeap(final List<T> list)
    {
        for (final T element : list)
        {
            heap.push(element);
        }
    }
    
    @Override
    public List<E> sort(final List<? extends E> list)
    {
        final List<E> result = Lists.newArrayList();
        
        fillHeap(list);
        
        while (!heap.isEmpty())
        {
            result.add(heap.pop());
        }
        
        heap.clear();
        
        return result;
    }
}
