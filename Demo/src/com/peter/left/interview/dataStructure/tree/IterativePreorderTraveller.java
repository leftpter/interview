package com.peter.left.interview.dataStructure.tree;

import java.util.function.Consumer;

import com.peter.left.interview.dataStructure.stack.ArrayStack;
import com.peter.left.interview.dataStructure.stack.Stack;

/**
 * Travel tree preorder iteratively.
 *
 * @param <E>
 */
public class IterativePreorderTraveller<E> implements Traveller<E>
{
    private void travelAllLeftChildren(final TreeNode<? extends E> root,
            final Consumer<E> consumer, final Stack<TreeNode<? extends E>> stack)
    {
        TreeNode<? extends E> node = root;
        
        while (null != node)
        {
            consumer.accept(node.getValue());
            
            if (null != node.getRightChild())
            {
                stack.push(node);
            }
            
            node = node.getLeftChild();
        }
    }
    
    @Override
    public void travel(final TreeNode<? extends E> root, final Consumer<E> consumer)
    {
        if (null != root)
        {
            final Stack<TreeNode<? extends E>> stack = new ArrayStack<>();
            
            TreeNode<? extends E> node = root;
            
            while (null != node)
            {
                // Travel all left children.
                travelAllLeftChildren(node, consumer, stack);
                
                // Get first right children should travel.
                if (!stack.isEmpty())
                {
                    node = stack.pop().getRightChild();
                }
                // Should stop.
                else
                {
                    break;
                }
            }
        }
    }
}
