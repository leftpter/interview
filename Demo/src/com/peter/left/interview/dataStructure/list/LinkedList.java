package com.peter.left.interview.dataStructure.list;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> extends AbstractList<E> {
    private int size = 0;
    // Have an always same head to make it easy.
    private final Element<E> head = new Element<>(null, null);
    
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
        
        void setValue(E value)
        {
            this.value = value;
        }
        
        void setNext(Element<E> next)
        {
            this.next = next;
        }
    }
    
    @Override
    public void add(final int index, final E element)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException(
                    String.format("excepted :[0, %d]; is %d", size, index));
        }
        
        // Insert in the head, should update the head.
        final Element<E> pos = getElement(index - 1);
        final Element<E> insertElement = new Element<>(element, pos.getNext());
        pos.setNext(insertElement);
        ++size;
    }
    
    // -1 express the head.
    private Element<E> getElement(final int index)
    {
        Element<E> pos = head;
        int i = -1;
        try
        {
            for (; i < index; ++i)
            {
                pos = pos.getNext();
            }
        }
        catch (final NullPointerException e)
        {
            throw new IllegalStateException(
                    String.format("LinkedList inner error, linked list end at position %d, the size is %d",
                            i, size));
        }
        
        return pos;
    }
    
    @Override
    public E set(final int index, final E element)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(
                    String.format("excepted :[0, %d); is %d", size, index));
        }
        
        final Element<E> elem = getElement(index);
        final E oldValue = elem.getValue();
        elem.setValue(element);
        
        return oldValue;
    }
    
    @Override
    public E remove(final int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(
                    String.format("excepted :[0, %d); is %d", size, index));
        }
        
        final Element<E> previousElement = getElement(index - 1);
        final Element<E> elem = previousElement.getNext();
        final E oldValue = elem.getValue();
        previousElement.setNext(elem.getNext());
        
        // Update the size.
        --size;
        
        return oldValue;
    }
    
    @Override
    public E get(final int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(
                    String.format("excepted :[0, %d); is %d", size, index));
        }

        return getElement(index).getValue();
    }

    @Override
    public int size()
    {
        return size;
    }
    
    @Override
    public Iterator<E> iterator()
    {
        return new linkedListIterator();
    }
    
    private class linkedListIterator implements Iterator<E>
    {
        private Element<E> previousPos = null;
        private Element<E> currentPos = head;
        private boolean removed = false;
        
        @Override
        public boolean hasNext()
        {
            return null != currentPos.getNext();
        }

        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException("next element is not avaible,"
                        + " should call hasNext before next to check the status");
            }
            // If current element was removed, the previous position doesn't
            // need to be changed.
            if (!removed)
            {
                previousPos = currentPos;
            }

            removed = false;
            
            currentPos = currentPos.getNext();
            return currentPos.getValue();
        }
        
        @Override
        public void remove()
        {
            if (!removed)
            {
                if (null == previousPos)
                {
                    throw new IllegalStateException(
                            "never called next to update the current position");
                }
                
                previousPos.setNext(currentPos.getNext());
                --size;
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
