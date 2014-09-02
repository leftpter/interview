package com.peter.left.interview.dataStructure.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.Validate;

public class LoopArrayQueue<E> implements Queue<E>
{
    private static final int DEFAULT_QUEUE_CAPACITY = 16;
    private final E[] elements;
    
    private int head;
    private int tail;
    
    @SuppressWarnings("unchecked")
    public LoopArrayQueue(final int capacity)
    {
        Validate.isTrue(capacity > 0, "capacity must be positive; is %d", capacity); 
        
        elements = (E[]) new Object[capacity + 1];
        
        head = 0;
        tail = 0;
    }
    
    public LoopArrayQueue()
    {
        this(DEFAULT_QUEUE_CAPACITY);
    }
    
    private void checkQueueFull()
    {
        if (getNextPosition(tail) == head)
        {
            throw new IllegalStateException("Queue is full");
        }
    }
    
    private void checkQueueEmpty()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Queue is empty");
        }
    }
    
    private int getNextPosition(final int pos)
    {
        return (pos + 1) % elements.length;
    }
    
    @Override
    public void enqueue(final E element)
    {
        checkQueueFull();
        
        elements[tail] = element;
        
        tail = getNextPosition(tail);
    }
    
    @Override
    public E dequeue()
    {
        checkQueueEmpty();
        
        final E element = elements[head];
        
        elements[head] = null;
        
        head = getNextPosition(head);
        
        return element;
    }
    
    @Override
    public E front()
    {
        checkQueueEmpty();
        
        return elements[head];
    }
    
    @Override
    public boolean isEmpty()
    {
        return (head == tail);
    }
    
    @Override
    public Iterator<E> iterator()
    {
        return new LoopArrayQueueIterator();
    }
    
    private class LoopArrayQueueIterator implements Iterator<E>
    {
        private int current = getPreviousPosition(head);
        
        private int getPreviousPosition(int pos)
        {
            return (pos - 1) % elements.length;
        }
        
        @Override
        public boolean hasNext()
        {
            return (getNextPosition(current) != tail);
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
            
            current = getNextPosition(current);
            
            return elements[current];
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray()
    {
        final E[] array;
        
        if (tail == head)
        {
            array = (E[]) new Object[0];
        }
        else if (tail > head)
        {
            array = (E[]) new Object[tail - head];
            System.arraycopy(elements, head, array, 0, tail-head);
        }
        else
        {
            array = (E[]) new Object[elements.length - head + tail];

            System.arraycopy(elements, head, array, 0, elements.length - head);
            System.arraycopy(elements, 0, array, elements.length - head, tail);
        }
        
        return array;
    }
}
