package com.peter.left.interview.treeLevelSum;

public class TreeNode {
	private final int value;
	private final TreeNode leftChild;
	private final TreeNode rightChild;
	
	public TreeNode(final int value, final TreeNode leftChild, final TreeNode rightChild)
	{
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public TreeNode getLeftChild()
	{
		return leftChild;
	}
	
	public TreeNode getRightChild()
	{
		return rightChild;
	}
}
