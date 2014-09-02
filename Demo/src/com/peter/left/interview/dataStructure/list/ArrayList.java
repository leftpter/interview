package com.peter.left.interview.dataStructure.list;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> extends AbstractList<E>
{
    private static int DEFAULT_LIST_CAPICITY = 16;
    @SuppressWarnings("unchecked")
    private E[] elements = (E []) new Object[DEFAULT_LIST_CAPICITY];
    private int size = 0;
    
    private void checkIndex(final int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(
                    String.format("excepted index [0, %d); is %d", size, index));
        }
    }
    
    private void ensureCapicity()
    {
        if (elements.length == size)
        {
            elements = Arrays.copyOf(elements, elements.length * 2 + 1);
        }
    }
    
    @Override
    public void add(final int index, final E element)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException(
                    String.format("excepted index [0, %d]; is %d", size, index));
        }

        ensureCapicity();
        
        System.arraycopy(elements, index, elements, index + 1, size - index);
        
        elements[index] = element;
        
        ++size;
    }
    
    @Override
    public E set(final int index, final E element)
    {
        checkIndex(index);
        
        final E oldValue = elements[index];
        
        elements[index] = element;
        
        return oldValue;
    }
    
    @Override
    public E remove(final int index)
    {
        checkIndex(index);
        
        final E oldValue = elements[index];
        
        // Move all elements behind the removed element one spot forward.
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        
        // Dereference the last element.
        elements[size - 1] = null;
        
        --size;
        
        return oldValue;
    }
    
    @Override
    public E get(int index)
    {
        checkIndex(index);
        return elements[index];
    }

    @Override
    public int size()
    {
        return size;
    }
    
    @Override
    public Iterator<E> iterator()
    {
        return new ArrayListIterator();
    }
    
    private class ArrayListIterator implements Iterator<E>
    {
        private int currentPos = -1;
        private boolean removed = false;

        @Override
        public boolean hasNext()
        {
            return (currentPos < size - 1);
        }

        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException("no available element, "
                        + "should call hasNext before next to check the status");
            }
            
            // If current item has been removed, don't change the position.
            if (!removed)
            {
                ++currentPos;
            }
            
            removed = false;
            
            return elements[currentPos];
        }
        
        @Override
        public void remove()
        {
            // For each next element, remove can be called only once.
            if (!removed)
            {
                if (currentPos == -1)
                {
                    throw new IllegalStateException("no avaible element,"
                            + " should call next before remove");
                }
                
                ArrayList.this.remove(currentPos);
                removed = true;
            }
            else
            {
                throw new IllegalStateException("remove has already been called"
                        + " after the last call to the next method");
            }
        }
    }
}
