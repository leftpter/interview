package com.peter.left.interview.dataStructure.queue;

/**
 * Interface definition of queue. 
 * <p>
 * Queue is a type of list which insert element at the tail (enqueue),
 * delete element at the head (dequeue).
 * </p>
 * 
 * @param <E> type of the queue.
 */
public interface Queue<E> extends Iterable<E>
{
    /**
     * Insert an element to tail of the queue.
     *
     * @param element element need to be inserted.
     * @throws IllegalStateException - queue is full for fix size queue.
     */
    void enqueue(E element);
    
    /**
     * Retrieve element at the head and delete it.
     * 
     * @return head element.
     * @throws NoSuchElementException - queue is empty.
     */
    E dequeue();
    
    /**
     * Retrieve element at the head but don't delete it.
     * 
     * @return head element.
     * @throws NoSuchElementException - queue is empty.
     */
    E front();
    
    /**
     * Return {@code true} if queue contains no element, otherwise (@code false}.
     * 
     * @return {@code true} if queue contains no element.
     *         (@code false} if queue contains any element.
     */
    boolean isEmpty();
    
    /**
     * Return array of elements begin from the head to tail.
     * 
     * @return array of elements with type of E.
     */
    E[] toArray();
}
