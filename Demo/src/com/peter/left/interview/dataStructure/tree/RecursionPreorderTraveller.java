package com.peter.left.interview.dataStructure.tree;

import java.util.function.Consumer;

/**
 * Travel tree by preorder.
 *
 * @param <E> type of value of element in the tree.
 */
public class RecursionPreorderTraveller<E> implements Traveller<E>
{
    @Override
    public void travel(final TreeNode<? extends E> root, final Consumer<E> consumer)
    {
        if (null != root)
        {
            consumer.accept(root.getValue());
            
            travel(root.getLeftChild(), consumer);
            travel(root.getRightChild(), consumer);
        }
    }
}
