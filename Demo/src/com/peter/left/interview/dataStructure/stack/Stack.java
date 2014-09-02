package com.peter.left.interview.dataStructure.stack;

/**
 * Interface definition of the stack.
 *
 * <p>
 * A stack is a type of list which user can only insert / delete element 
 * at top (one side of list).
 * </p>
 *
 * @param <E> type of elements in the stack
 */
public interface Stack<E> extends Iterable<E>
{
    /**
     * Retrieve the top element in the stack and remove it from the stack.
     *
     * @return top element.
     * @throws NoSuchElementException - stack is empty.
     */
    E pop();
    
    /**
     * Put an element into the stack, it will be at the top.
     *
     * @param element element need to put into the stack.
     * @throws IllegalStateException - stack is full (For fix size stack).
     */
    void push(E element);
    
    /**
     * Retrieve the top element in the stack but doesn't remove it from the stack.
     *
     * @return top element.
     * @throws NoSuchElementException - stack is empty.
     */
    E peak();
    
    /**
     * Return {@code true} if the stack contains no elements, otherwise {@code false}.
     *
     * @return {@code true} if the stack contains no elements.
     *         {@code false} if the stack contains any element.
     */
    boolean isEmpty();
}
