package com.peter.left.interview.dataStructure.heap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertThat;

public class ArrayHeapTest
{
    private Heap<Integer> heap;
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp()
    {
        heap = new ArrayHeap<Integer>();
    }
    
    @Test
    public void emptyHeap_isEmptyShould_returnTrue()
    {
        assertThat(heap.isEmpty(), equalTo(true));
    }
    
    @Test
    public void singletonHeap_isEmptyShould_returnTrue()
    {
        heap.push(1);
        
        assertThat(heap.isEmpty(), equalTo(false));
    }
    
    @Test
    public void multipleElementsHeap_isEmptyShould_returnTrue()
    {
        heap.push(1);
        heap.push(2);
        heap.push(3);
        heap.push(4);
        heap.push(5);
        
        assertThat(heap.isEmpty(), equalTo(false));
    }
    
    @Test
    public void emptyHeap_peakShould_fail()
    {
        exception.expect(NoSuchElementException.class);
        
        heap.peak();
    }
    
    @Test
    public void singletonHeap_peakShould_returnThisElement()
    {
        heap.push(1);
        
        assertThat(heap.peak(), equalTo(1));
    }
    
    @Test
    public void ascendantElementsHeap_peakShould_returnMinElement()
    {
        for (int i = 0; i < 10; ++i)
        {
            heap.push(i);
            
            assertThat(heap.peak(), equalTo(0));
        }
    }
    
    @Test
    public void descendantElementsHeap_peakShould_returnMinElement()
    {
        for (int i = 9; i >= 0; --i)
        {
            heap.push(i);
            
            assertThat(heap.peak(), equalTo(i));
        }
    }
    
    @Test
    public void descendantThenAscendantElementsHeap_peakShould_returnMinElement()
    {
        for (int i = 9; i >= 5; --i)
        {
            heap.push(i);
            
            assertThat(heap.peak(), equalTo(i));
        }
        
        for (int i = 0; i < 5; ++i)
        {
            heap.push(i);
            
            assertThat(heap.peak(), equalTo(0));
        }
    }
    
    @Test
    public void emptyHeap_iteratorShould_hasNoNext()
    {
        assertThat(heap.iterator().hasNext(), equalTo(false));
    }
    
    @Test
    public void singletonHeap_iteratorShould_hasNext()
    {
        heap.push(1);
        
        assertThat(heap.iterator().hasNext(), equalTo(true));
    }
    
    @Test
    public void multipleElementsHeap_iteratorShould_hasNext()
    {
        heap.push(1);
        heap.push(2);
        heap.push(3);
        heap.push(4);
        heap.push(5);
        
        assertThat(heap.iterator().hasNext(), equalTo(true));
    }
    
    @Test
    public void multipleElementsHeap_iteratorShould_actAsExpected()
    {
        final int test_count = 5;
        
        for (int i = 0; i < test_count; ++i)
        {
            heap.push(i);
        }
        
        final Iterator<Integer> iterator = heap.iterator();
        
        for (int i = 0; i < test_count; ++i)
        {
            assertThat(iterator.hasNext(), equalTo(true));
            
            final int value = iterator.next();
            
            assertThat(value, lessThan(test_count));
            assertThat(value, greaterThanOrEqualTo(0));
        }
        
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void singlePush_itShould_haveSingleElement()
    {
        heap.push(1);
        
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(1));
    }
    
    @Test
    public void multiplePush_itShould_haveMultipleElements()
    {
        heap.push(1);
        
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(1));
        
        heap.push(2);
        
        assertThat(heap, iterableWithSize(2));
        assertThat(heap, containsInAnyOrder(1, 2));
        
        heap.push(3);
        
        assertThat(heap, iterableWithSize(3));
        assertThat(heap, containsInAnyOrder(1, 2, 3));
        
        heap.push(4);
        
        assertThat(heap, iterableWithSize(4));
        assertThat(heap, containsInAnyOrder(1, 2, 3, 4));
    }
    
    @Test
    public void multiplePopAfterPush_itShould_actAsExpected()
    {
        heap.push(1);
        heap.push(2);
        heap.push(3);
        heap.push(4);
        heap.push(5);
        
        assertThat(heap, iterableWithSize(5));
        assertThat(heap, containsInAnyOrder(1, 2, 3, 4, 5));
        
        assertThat(heap.pop(), equalTo(1));
        assertThat(heap, iterableWithSize(4));
        assertThat(heap, containsInAnyOrder(2, 3, 4, 5));
        
        assertThat(heap.pop(), equalTo(2));
        assertThat(heap, iterableWithSize(3));
        assertThat(heap, containsInAnyOrder(3, 4, 5));
        
        assertThat(heap.pop(), equalTo(3));
        assertThat(heap, iterableWithSize(2));
        assertThat(heap, containsInAnyOrder(4, 5));
        
        assertThat(heap.pop(), equalTo(4));
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(5));
        
        assertThat(heap.pop(), equalTo(5));
        assertThat(heap, iterableWithSize(0));
    }
    
    @Test
    public void multipleOnePushThenOnePop_itShould_actAsExpected()
    {
        heap.push(1);
        
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(1));
        assertThat(heap.pop(), equalTo(1));
        assertThat(heap, iterableWithSize(0));
        
        heap.push(2);
        
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(2));
        assertThat(heap.pop(), equalTo(2));
        assertThat(heap, iterableWithSize(0));
        
        heap.push(3);
        
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(3));
        assertThat(heap.pop(), equalTo(3));
        assertThat(heap, iterableWithSize(0));
        
        heap.push(4);
        
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(4));
        assertThat(heap.pop(), equalTo(4));
        assertThat(heap, iterableWithSize(0));
        
        heap.push(5);
        
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(5));
        assertThat(heap.pop(), equalTo(5));
        assertThat(heap, iterableWithSize(0));
    }
    
    @Test
    public void multipleTwoPushThenTwoPop_itShould_actAsExpected()
    {
        heap.push(1);
        heap.push(2);
        
        assertThat(heap, iterableWithSize(2));
        assertThat(heap, containsInAnyOrder(1, 2));
        assertThat(heap.pop(), equalTo(1));
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(2));
        assertThat(heap.pop(), equalTo(2));
        assertThat(heap, iterableWithSize(0));
        
        
        heap.push(3);
        heap.push(4);
        
        assertThat(heap, iterableWithSize(2));
        assertThat(heap, containsInAnyOrder(3, 4));
        assertThat(heap.pop(), equalTo(3));
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(4));
        assertThat(heap.pop(), equalTo(4));
        assertThat(heap, iterableWithSize(0));
    }
    
    @Test
    public void multipleTwoPushThenOnePop_itShould_actAsExpected()
    {
        heap.push(2);
        heap.push(1);
        
        assertThat(heap, iterableWithSize(2));
        assertThat(heap, containsInAnyOrder(1, 2));
        assertThat(heap.pop(), equalTo(1));
        assertThat(heap, iterableWithSize(1));
        assertThat(heap, containsInAnyOrder(2));
        
        
        heap.push(4);
        heap.push(3);
        
        assertThat(heap, iterableWithSize(3));
        assertThat(heap, containsInAnyOrder(2, 3, 4));
        assertThat(heap.pop(), equalTo(2));
        assertThat(heap, iterableWithSize(2));
        assertThat(heap, containsInAnyOrder(3, 4));
    }
}
