package com.peter.left.interview.dataStructure.problems.reverseLinkedList;

public class LinkedListNode<T>
{
    private T value;
    private LinkedListNode<T> next;
    
    public LinkedListNode(final T value, final LinkedListNode<T> next)
    {
        this.value = value;
        this.next = next;
    }
    
    public T getValue()
    {
        return value;
    }
    
    public void setValue(final T value)
    {
        this.value = value;
    }
    
    public LinkedListNode<T> getNext()
    {
        return next;
    }
    
    public void setNext(final LinkedListNode<T> next)
    {
        this.next = next;
    }
}
