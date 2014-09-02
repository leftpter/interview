package com.peter.left.interview.dataStructure.problems.reverseLinkedList;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class SimpleReverseLinkedListTest
{
    private ReverseLinkedList<Integer> reverser;
    
    @Before
    public void setUp()
    {
        reverser = new SimpleReverseLinkedList<>();
    }
    
    @Test
    public void emptyList_itShould_returnEmpty()
    {
        assertThat(reverser.reverse(null), nullValue());
    }
    
    @Test
    public void singletonList_itShould_returnSingleton()
    {
        final LinkedListNode<Integer> head = new LinkedListNode<>(1, null);
        
        assertThat(reverser.reverse(head), sameInstance(head));
    }
    
    @Test
    public void MultipleElementsList_itShould_returnReversedList()
    {
        final LinkedListNode<Integer> node3 = new LinkedListNode<>(3, null);
        final LinkedListNode<Integer> node2 = new LinkedListNode<>(2, node3);
        final LinkedListNode<Integer> node1 = new LinkedListNode<>(1, node2);
        
        assertThat(reverser.reverse(node1), sameInstance(node3));
        assertThat(node3.getNext(), sameInstance(node2));
        assertThat(node2.getNext(), sameInstance(node1));
        assertThat(node1.getNext(), nullValue());
    }
}
