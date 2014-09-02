package com.peter.left.interview.dataStructure.heap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayHeap<E extends Comparable<E>> implements Heap<E>
{
    private static final int DEFAULT_HEAP_SIZE = 15;
    private static final int HEAD_POSITION = 0;
    private Object[] elements;
    private int size;
    
    public ArrayHeap(final int capacity)
    {
        elements = new Object[capacity];
    }
    
    public ArrayHeap()
    {
        this(DEFAULT_HEAP_SIZE);
    }
    
    @SuppressWarnings("unchecked")
    private E get(final int index)
    {
        return (E) elements[index];
    }
    
    @Override
    public boolean isEmpty()
    {
        return (0 == size);
    }
    
    private void checkEmpty()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("heap is empty");
        }
    }
    
    @Override
    public E peak()
    {
        checkEmpty();
        return (E) get(HEAD_POSITION);
    }
    
    private void swap(final int i, final int j)
    {
        if (i != j)
        {
            final E temp = get(i);
            
            elements[i] = elements[j];
            elements[j] = temp;
        }
    }
    
    private int downOneLayer(final int rootIndex)
    {
        final int downIndex;
        
        final int leftChild = 2 * rootIndex + 1;
        final int rightChild = 2 * rootIndex + 2;
        
        if (leftChild < size)
        {
            final boolean bLeft;
            
            final E left = get(leftChild);
            final E right;
            
            if (rightChild < size)
            {
                right = get(rightChild);
                
                bLeft = (left.compareTo(right) <= 0);
            }
            else
            {
                right = null;
                
                bLeft = true;
            }
            
            final E minChild = bLeft ? left : right;
            
            // root is larger than one of the children.
            if (get(rootIndex).compareTo(minChild) > 0)
            {
                downIndex = bLeft ? leftChild : rightChild;
                
                swap(downIndex, rootIndex);
                
            }
            else
            {
                downIndex = size;
            }
        }
        else
        {
            downIndex = size;
        }
        
        return downIndex;
    }
    
    private void downHeap()
    {
        if (size > 1)
        {
            int current = HEAD_POSITION;
            
            while (current < size)
            {
                current = downOneLayer(current);
            }
        }
    }
    
    @Override
    public E pop()
    {
        checkEmpty();
        
        final E head = get(HEAD_POSITION);
        
        elements[HEAD_POSITION] = elements[size - 1];
        
        elements[--size] = null;
        
        downHeap();
        
        return head;
    }
    
    public void ensureCapacity()
    {
        if (elements.length == size)
        {
            elements = Arrays.copyOf(elements, elements.length * 2 + 1);
        }
    }
    
    private int upOneLayer(final int childIndex)
    {
        final int rootIndex = (childIndex - 1) / 2;;
        final int index;
        
        if (get(childIndex).compareTo(get(rootIndex)) < 0)
        {
            swap(childIndex, rootIndex);
            
            index = rootIndex;
        }
        else
        {
            index = 0;
        }
        
        return index;
    }
    
    private void upHeap()
    {
        if (size > 1)
        {
            int current = size - 1;
            
            while (0 != current)
            {
                current = upOneLayer(current);
            }
        }
    }
    
    @Override
    public void push(final E element)
    {
        ensureCapacity();
        
        elements[size++] = element;
        
        upHeap();
    }
    
    @Override
    public void clear()
    {
        for (int i = 0; i < size; ++i)
        {
            elements[i] = null;
        }
        
        size = 0;
    }
    
    @Override
    public Iterator<E> iterator()
    {
        return new ArrayHeapIterator();
    }
    
    private class ArrayHeapIterator implements Iterator<E>
    {
        private int currentPos = HEAD_POSITION - 1;
        
        @Override
        public boolean hasNext()
        {
            return (currentPos < (size - 1));
        }
        
        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new IllegalStateException("no next element, "
                        + "should call hasNext method to check state "
                        + "before call next method");
            }
            
            return get(++currentPos);
        }
    }
}
