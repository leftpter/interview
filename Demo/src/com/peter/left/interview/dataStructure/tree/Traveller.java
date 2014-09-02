package com.peter.left.interview.dataStructure.tree;

import java.util.function.Consumer;

/**
 * Interface to travel tree.
 *
 * @param <E> type of value of element in tree.
 */
public interface Traveller<E>
{
    /**
     * Travel the tree.
     * 
     * @param root root of the tree.
     * @param consumer consumer for each element in the tree.
     */
    void travel(TreeNode<? extends E> root, Consumer<E> consumer);
}
