package com.peter.left.interview.dataStructure.problems.reverseLinkedList;

public class SimpleReverseLinkedList<T> implements ReverseLinkedList<T>
{
    @Override
    public LinkedListNode<T> reverse(final LinkedListNode<T> head)
    {
        LinkedListNode<T> oldHead = head;
        LinkedListNode<T> newHead = null;
        
        while (null != oldHead)
        {
            final LinkedListNode<T> next = oldHead.getNext();
            
            oldHead.setNext(newHead);
            
            newHead = oldHead;
            
            oldHead = next;
        }
        
        return newHead;
    }
}
