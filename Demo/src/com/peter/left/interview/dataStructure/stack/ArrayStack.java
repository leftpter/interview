package com.peter.left.interview.dataStructure.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import lombok.ToString;

import org.apache.commons.lang3.Validate;

@ToString(exclude="size")
public class ArrayStack<E> implements Stack<E>
{
    private static final int DEFAULT_STACK_CAPACITY = 16;
    private E[] elements;
    private int size;     
    
    @SuppressWarnings("unchecked")
    public ArrayStack(final int capacity)
    {
        Validate.isTrue(capacity > 0, "capacity must be positive, is %d", capacity);

        elements = (E[]) new Object[capacity];
        size = 0;
    }
    
    public ArrayStack()
    {
        this(DEFAULT_STACK_CAPACITY);
    }
    
    @Override
    public int hashCode()
    {
        return Arrays.hashCode(toArray());
    }
    
    public E[] toArray()
    {
        return (E[]) Arrays.copyOf(elements, size);
    }
    
    @Override
    public boolean equals(final Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        
        if (obj instanceof Stack)
        {
            @SuppressWarnings("unchecked")
            final Stack<Object> stack = (Stack<Object>) obj;
            final Iterator<Object> other = stack.iterator();
            for (final Iterator<E> iterator = iterator(); iterator.hasNext(); )
            {
                // Don't have same number of elements.
                if (!other.hasNext())
                {
                    return false;
                }
                
                final Object otherObj = other.next();
                final E thisObj = iterator.next();
                
                // This elements are not equal.
                if (!((null == otherObj) ? ((null == thisObj) ? true : false) : otherObj.equals(thisObj)))
                {
                    return false;
                }
            }
            
            // Both stacks reach end.
            if (!other.hasNext())
            {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public E pop()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("stack is empty");
        }
        
        final E oldValue = elements[size - 1];
        
        elements[size - 1] = null;
        
        --size;
        
        return oldValue;
    }
    
    private void ensureCapacity()
    {
        if (size == elements.length)
        {
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
    }
    
    @Override
    public void push(final E element)
    {
        ensureCapacity();
        
        elements[size] = element;
        
        ++size;
    }
    
    @Override
    public E peak()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("stack is empty");
        }
        
        return elements[size - 1];
    }
    
    @Override
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    @Override
    public Iterator<E> iterator()
    {
        return new ArrayStackIterator();
    }
    
    private class ArrayStackIterator implements Iterator<E>
    {
        private int currentPos = size;
        @Override
        public boolean hasNext()
        {
            return (currentPos > 0);
        }
        
        @Override
        public E next()
        {
            if (currentPos <= 0)
            {
                throw new IllegalStateException("no next element,"
                        + " should call hasNext to check the state before call next");
            }
            return elements[--currentPos];
        }
    }
}
