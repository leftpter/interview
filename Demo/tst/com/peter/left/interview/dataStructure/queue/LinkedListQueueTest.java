package com.peter.left.interview.dataStructure.queue;

import static org.hamcrest.Matchers.equalTo;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertThat;


public class LinkedListQueueTest
{
    private Queue<Object> queue;
    private final Object[] objs = {new Object(), Boolean.valueOf(true),
            Integer.valueOf(12), String.valueOf("dsdsdssdd"),
            Double.valueOf(233.233)
            }; 
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    private void fillQueue(final Queue<Object> queue, final Object[] objs)
    {
        for (final Object obj : objs)
        {
            queue.enqueue(obj);
        }
    }
    
    @Before
    public void setUp()
    {
        queue = new LinkedListQueue<>();
    }
    
    @Test
    public void emptyQueue_isEmptyShould_returnTrue()
    {
        assertThat(queue.isEmpty(), equalTo(true));
    }
    
    @Test
    public void singletonQueue_isEmptyShould_returnFalse()
    {
        queue.enqueue(new Object());
        
        assertThat(queue.isEmpty(), equalTo(false));
    }
    
    @Test
    public void multipleElementsQueue_isEmptyShould_returnFalse()
    {
        fillQueue(queue, objs);
        
        assertThat(queue.isEmpty(), equalTo(false));
    }
    
    @Test
    public void enqueueOneElement_itShould_getExpectedQueue()
    {
        final Object obj = new Object();
        
        queue.enqueue(obj);
        
        final Object[] objs = {obj};
        
        assertThat(queue.toArray(), equalTo(objs));
    }
    
    @Test
    public void enqueueMultipleElements_itShould_getExpectedQueue()
    {
        fillQueue(queue, objs);
        
        assertThat(queue.toArray(), equalTo(objs));
    }
    
    @Test
    public void dequeueEmptyQueue_itShould_fail()
    {
        exception.expect(NoSuchElementException.class);
        
        queue.dequeue();
    }
    
    @Test
    public void dequeueOneQueue_itShould_getExpectedQueue()
    {
        fillQueue(queue, objs);
        
        assertThat(queue.dequeue(), equalTo(objs[0]));
        
        final Object[] destObjs = new Object[objs.length - 1];
        
        System.arraycopy(objs, 1, destObjs, 0, objs.length - 1);
        
        assertThat(queue.toArray(), equalTo(destObjs));        
    }
    
    @Test
    public void dequeueAllElements_itShould_getEmptyQueue()
    {
        fillQueue(queue, objs);
        
        for (int index = 0; index < objs.length; ++index)
        {
            assertThat(queue.dequeue(), equalTo(objs[index]));
        }
        
        assertThat(queue.isEmpty(), equalTo(true));
    }
    
    @Test
    public void frontEmptyQueue_itShould_fail()
    {
        exception.expect(NoSuchElementException.class);
        
        queue.front();
    }
    
    @Test
    public void onceFrontQueue_itShould_keepQueueSame()
    {
        fillQueue(queue, objs);
        
        assertThat(queue.front(), equalTo(objs[0]));
        
        assertThat(queue.toArray(), equalTo(objs));        
    }
    
    @Test
    public void multipleFrontQueue_itShould_keepQueueSame()
    {
        fillQueue(queue, objs);
        
        assertThat(queue.front(), equalTo(objs[0]));
        assertThat(queue.front(), equalTo(objs[0]));
        assertThat(queue.front(), equalTo(objs[0]));
        assertThat(queue.front(), equalTo(objs[0]));
        assertThat(queue.front(), equalTo(objs[0]));
        
        assertThat(queue.toArray(), equalTo(objs));        
    }
    
    @Test
    public void oneEnqueueOneDequeue_itShould_getEmptyQueue()
    {
        final Object obj = new Object();
        
        queue.enqueue(obj);
        
        assertThat(queue.dequeue(), equalTo(obj));
        
        assertThat(queue.isEmpty(), equalTo(true));        
    }
    
    @Test
    public void multipleEnqueueMultipleDequeue_itShould_getExpectedQueue()
    {
        final Object obj1 = new Object();
        final Object obj2 = new Object();
        
        queue.enqueue(obj1);
        queue.enqueue(obj2);
        
        assertThat(queue.dequeue(), equalTo(obj1));
        
        final Object obj3 = new Object();
        
        queue.enqueue(obj3);
        
        assertThat(queue.dequeue(), equalTo(obj2));
        
        final Object obj4 = new Object();
        
        queue.enqueue(obj4);
        
        assertThat(queue.dequeue(), equalTo(obj3));
        
        final Object[] objs = {obj4};
        
        assertThat(queue.toArray(), equalTo(objs));        
    }
    
    @Test
    public void emptyQueue_iteratorHasNextShould_returnFalse()
    {
        assertThat(queue.iterator().hasNext(), equalTo(false));
    }
    
    @Test
    public void emptyQueue_iteratorNextShould_fail()
    {
        exception.expect(IllegalStateException.class);
        
        queue.iterator().next();
    }
    
    @Test
    public void singletonQueue_iteratorHasNextShould_returnTrue()
    {
        queue.enqueue(new Object());
        
        assertThat(queue.iterator().hasNext(), equalTo(true));
    }
    
    @Test
    public void multipleElementsQueue_iteratorHasNextShould_returnTrue()
    {
        fillQueue(queue, objs);
        
        assertThat(queue.iterator().hasNext(), equalTo(true));
    }
    
    @Test
    public void queueIterator_itShould_actAsExpected()
    {
        fillQueue(queue, objs);
        
        final Iterator<Object> iterator = queue.iterator();
        
        for (int index = 0; index < objs.length; ++index)
        {
            assertThat(iterator.hasNext(), equalTo(true));
            assertThat(iterator.next(), equalTo(objs[index]));
        }
        
        assertThat(iterator.hasNext(), equalTo(false));
    }
}
