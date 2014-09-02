package com.peter.left.interview.dataStructure.problems.CollapseIterators;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class CollapseIterator<E> implements Iterator<E>
{
    private Iterator<E> current;
    
    private final Iterator<Iterator<E>> iterator;
    
    public static <E> CollapseIterator<E> createInstance(final List<Iterator<E>> iterators)
    {
        Validate.notNull(iterators, "iterators must not be null");
        
        return new CollapseIterator<>(iterators.iterator());
    }
    
    private CollapseIterator(final Iterator<Iterator<E>> iterator)
    {
        assert iterator != null : "iterator must not be null";
        
        this.iterator = iterator;
    }
    
    private void moveToNextAvailableIterator()
    {
        while (iterator.hasNext())
        {
            // Get next iterator in the list.
            current = iterator.next();
            
            // Such iterator has next element.
            if (current.hasNext())
            {
                break;
            }
            else
            {
                current = null;
            }
        }
    }
    
    @Override
    public boolean hasNext()
    {
        final boolean hasNext;
        
        // First call hasNext or reach the end of current iterator.
        if (null == current || !current.hasNext())
        {
            // Move to next available iterator.
            moveToNextAvailableIterator();
        }
        
        // Not reach the end of iterators.
        if (null != current)
        {
            hasNext = current.hasNext();
        }
        else
        {
            hasNext = false;
        }
        
        return hasNext;
    }
    
    @Override
    public E next()
    {
        if (!hasNext())
        {
            throw new IllegalStateException("no next element, should call hasNext"
                    + " method to check the state before call next method");
        }
        
        return current.next();
    }
    
    @Override
    public void remove()
    {
        current.remove();
    }
}
