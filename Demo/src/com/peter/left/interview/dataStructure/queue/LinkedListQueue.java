package com.peter.left.interview.dataStructure.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E>
{
    private final Element<E> head;
    private final Element<E> tail;
    
    public LinkedListQueue()
    {
        head = new Element<>(null, null, null);
        tail = new Element<>(null, null, head);
        
        head.setNext(tail);
    }
    
    @Override
    public void enqueue(final E element)
    {
        final Element<E> elem = new Element<>(element, tail, tail.getPrevious());

        tail.getPrevious().setNext(elem);
        tail.setPrevious(elem);
    }
    
    @Override
    public E dequeue()
    {
        if (head.getNext() == tail)
        {
            throw new NoSuchElementException("queue is empty");
        }
        
        final Element<E> element = head.getNext();
        
        head.setNext(element.getNext());
        element.getNext().setPrevious(head);
        
        return element.getValue();
    }
    
    @Override
    public E front()
    {
        if (head.getNext() == tail)
        {
            throw new NoSuchElementException("queue is empty");
        }
        
        return head.getNext().getValue();
    }
    
    @Override
    public boolean isEmpty()
    {
        return (head.getNext() == tail);
    }
    
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        
        if (obj instanceof Queue)
        {
            @SuppressWarnings("unchecked")
            final Queue<Object> queue = (Queue<Object>) obj;
            
            return Arrays.equals(toArray(), queue.toArray());
        }
        
        return false;
    }
    
    @Override
    public int hashCode()
    {
        return Arrays.hashCode(toArray());
    }
    
    @Override
    public E[] toArray()
    {
        @SuppressWarnings("unchecked")
        E[] array = (E[]) new Object[0];
        
        for (final E element : this)
        {
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = element;
        }
        
        return array;
    }
    
    @Override
    public Iterator<E> iterator()
    {
        return new LinkedListQueueIterator();
    }
    
    private class LinkedListQueueIterator implements Iterator<E>
    {
        private Element<E> current = head;
        
        @Override
        public boolean hasNext()
        {
            return (current.getNext() != tail);
        }
        
        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new IllegalStateException("no next element" + 
                        ", should call hasNext method to check state" +
                        " before call next method");
            }
            
            current = current.getNext();
            
            return current.getValue();
        }
    }
    
    private static class Element<E>
    {
        private E value;
        private Element<E> next;
        private Element<E> previous;
        
        Element(final E value, final Element<E> next, final Element<E> previous)
        {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
        
        E getValue()
        {
            return value;
        }
        
        void setValue(final E value)
        {
            this.value = value;
        }
        
        Element<E> getPrevious()
        {
            return previous;
        }
        
        void setPrevious(final Element<E> previous)
        {
            this.previous = previous;
        }
        
        Element<E> getNext()
        {
            return next;
        }
        
        void setNext(Element<E> next)
        {
            this.next = next;
        }
    }
}
