package com.peter.left.interview.dataStructure.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.ArrayUtils;

public class LinkedListStack<E> implements Stack<E>
{
    private final Element<E> head;
    
    LinkedListStack()
    {
        head = new Element<>(null, null);
    }
    
    @Override
    public String toString()
    {
        return toArray().toString();
    }
    
    @Override
    public int hashCode()
    {
        return Arrays.hashCode(toArray());
    }
    
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        
        if (obj instanceof Stack)
        {
            @SuppressWarnings("unchecked")
            final Stack<Object> stack = (Stack<Object>) obj;
            
            final Iterator<Object> iteratorObj = stack.iterator();
            
            for (final Iterator<E> iterator = iterator(); iterator.hasNext(); )
            {
                // Don't have same number of elements.
                if (!iteratorObj.hasNext())
                {
                    return false;
                }
                
                final Object other = iteratorObj.next();
                final E element = iterator.next();
                
                // Elements are not equal.
                if (!((null == element) ? ((null == other) ? true : false) : element.equals(other)))
                {
                    return false;
                }
            }
            
            // Both stacks reach the end.
            if (!iteratorObj.hasNext())
            {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public E pop()
    {
        if (null == head.getNext())
        {
            throw new NoSuchElementException("the stack is empty");
        }
        
        final Element<E> element = head.getNext();
        head.setNext(element.getNext());
        
        return element.getValue();
    }
    
    @Override
    public E peak()
    {
        if (null == head.getNext())
        {
            throw new NoSuchElementException("the stack is empty");
        }
        
        return head.getNext().getValue();
    }
    
    @Override
    public void push(final E element)
    {
        final Element<E> elem = new Element<>(element, head.getNext());
        head.setNext(elem);
    }
    
    @Override
    public boolean isEmpty()
    {
        return (null == head.getNext());
    }
    
    @Override
    public Iterator<E> iterator()
    {
        return new LinkedListIterator();
    }
    
    public E[] toArray()
    {
        @SuppressWarnings("unchecked")
        E[] array = (E[]) new Object[0];
        
        for (final E element : this)
        {
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = element;
        }
        
        ArrayUtils.reverse(array);
        return array;
    }
    
    private class LinkedListIterator implements Iterator<E>
    {
        private Element<E> currentPos;
        
        LinkedListIterator()
        {
            currentPos = head;
        }
        
        @Override
        public boolean hasNext()
        {
            return (null != currentPos.getNext());
        }
        
        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new IllegalStateException("no next element,"
                        + " should call hasNext method to check state before call next method");
            }
            currentPos = currentPos.getNext();
            
            return currentPos.getValue();
        }
    }
    
    private static class Element<E>
    {
        private E value;
        private Element<E> next;
        
        Element(final E value, final Element<E> next)
        {
            this.value = value;
            this.next = next;
        }
        
        E getValue()
        {
            return value;
        }
        
        Element<E> getNext()
        {
            return next;
        }
        
        void setValue(final E value)
        {
            this.value = value;
        }
        
        void setNext(final Element<E> next)
        {
            this.next = next;
        }
    }
}
