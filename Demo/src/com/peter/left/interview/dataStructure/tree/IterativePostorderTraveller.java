package com.peter.left.interview.dataStructure.tree;

import java.util.function.Consumer;

import lombok.ToString;

import com.peter.left.interview.dataStructure.stack.ArrayStack;
import com.peter.left.interview.dataStructure.stack.Stack;

public class IterativePostorderTraveller<E> implements Traveller<E>
{
    private TreeNode<? extends E> processStack(
            final Stack<TreeNodeWithState<? extends E>> stack, final Consumer<E> consumer)
    {
        TreeNode<? extends E> node = null;

        while (node == null)
        {
            if (stack.isEmpty())
            {
                break;
            }
            
            TreeNodeWithState<? extends E> state = stack.pop();
            TreeNode<? extends E> tempNode = state.getNode();
            
            switch (state.getState())
            {
                case ACCESSED_LEFT:
                    // Left child accessed and right child is null.
                    if (null == tempNode.getRightChild())
                    {
                        consumer.accept(tempNode.getValue());
                    }
                    // Start to access the right child.
                    else
                    {
                        // Update the state and push it into the state again.
                        stack.push(new TreeNodeWithState<>(AccessState.ACCESSED_RIGHT, tempNode));
                        
                        node = tempNode.getRightChild();
                    }
                    break;

                case ACCESSED_RIGHT:
                    consumer.accept(tempNode.getValue());
                    break;
                    
                default:
                    throw new IllegalStateException("unknown state :" + state.getState());
            }
        }
        
        return node;
    }
    
    @Override
    public void travel(final TreeNode<? extends E> root, final Consumer<E> consumer)
    {
        final Stack<TreeNodeWithState<? extends E>> stack = new ArrayStack<>();
        
        TreeNode<? extends E> node = root;
        
        while (null != node)
        {
            if (null == node.getLeftChild() && null == node.getRightChild())
            {
                consumer.accept(node.getValue());

                node = processStack(stack, consumer);
            }
            else if (null == node.getLeftChild())
            {
                stack.push(new TreeNodeWithState<>(AccessState.ACCESSED_RIGHT, node));
                node = node.getRightChild();
            }
            else if (null == node.getRightChild())
            {
                stack.push(new TreeNodeWithState<>(AccessState.ACCESSED_RIGHT, node));
                node = node.getLeftChild();
            }
            else
            {
                stack.push(new TreeNodeWithState<>(AccessState.ACCESSED_LEFT, node));
                node = node.getLeftChild();
            }
        }
    }
    
    private static enum AccessState
    {
        ACCESSED_LEFT,
        ACCESSED_RIGHT,
    }
    
    @ToString
    private static class TreeNodeWithState<E>
    {
        private AccessState state;
        private final TreeNode<? extends E> node;
        
        TreeNodeWithState(final AccessState state, final TreeNode<? extends E> node)
        {
            this.state = state;
            this.node = node;
        }
        
        AccessState getState()
        {
            return state;
        }
        
        TreeNode<? extends E> getNode()
        {
            return node;
        }
    }
}
