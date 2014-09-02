package com.peter.left.interview.dataStructure.tree;

import java.util.function.Consumer;

import com.peter.left.interview.dataStructure.stack.ArrayStack;
import com.peter.left.interview.dataStructure.stack.Stack;

public class IterativeInorderTraveller<E> implements Traveller<E>
{
    private void travelAllLeftChildren(final TreeNode<? extends E> root,
            final Stack<TreeNode<? extends E>> stack)
    {
        TreeNode<? extends E> node = root;
        while (null != node)
        {
            stack.push(node);
            
            node = node.getLeftChild();
        }
    }
    @Override
    public void travel(final TreeNode<? extends E> root, final Consumer<E> consumer)
    {
        final Stack<TreeNode<? extends E>> stack = new ArrayStack<>();
        
        TreeNode<? extends E> node = root;
        
        while (null != node)
        {
            travelAllLeftChildren(node, stack);
            
            while (!stack.isEmpty())
            {
                node = stack.pop();
                
                consumer.accept(node.getValue());
                
                node = node.getRightChild();
                
                if (null != node)
                {
                    break;
                }
            }
        }
    }
}
