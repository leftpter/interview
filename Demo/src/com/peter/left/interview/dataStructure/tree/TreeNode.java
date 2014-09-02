package com.peter.left.interview.dataStructure.tree;

import lombok.ToString;

@ToString
public class TreeNode<E>
{
    private E value;
    private TreeNode<E> leftChild;
    private TreeNode<E> rightChild;
    
    public TreeNode(final E value, final TreeNode<E> leftChild, final TreeNode<E> rightChild)
    {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    public TreeNode(final E value)
    {
        this(value, null, null);
    }
    
    public E getValue()
    {
        return value;
    }
    
    public TreeNode<E> getLeftChild()
    {
        return leftChild;
    }
    
    public TreeNode<E> getRightChild()
    {
        return rightChild;
    }
    
    public void setValue(final E value)
    {
        this.value = value;
    }
    
    public void setLeftChild(final TreeNode<E> leftChild)
    {
        this.leftChild = leftChild;
    }
    
    public void setRightChild(final TreeNode<E> rightChild)
    {
        this.rightChild = rightChild;
    }
}
