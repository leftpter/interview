package com.peter.left.interview.dataStructure.tree;

import java.util.function.Consumer;

/**
 * Travel tree by post order.
 *
 * @param <E> type of value of element in the tree.
 */
public class RecursionPostorderTraveller<E> implements Traveller<E>
{
    @Override
    public void travel(final TreeNode<? extends E> root, final Consumer<E> consumer)
    {
        if (null != root)
        {
            travel(root.getLeftChild(), consumer);
            travel(root.getRightChild(), consumer);
            
            consumer.accept(root.getValue());
        }
    }
}
