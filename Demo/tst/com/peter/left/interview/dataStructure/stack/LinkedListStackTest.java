package com.peter.left.interview.dataStructure.stack;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class LinkedListStackTest
{
    private final Object[] objs = {new Object(), Boolean.valueOf(true),
            Integer.valueOf(12), String.valueOf("dsdsdssdd"),
            Double.valueOf(233.233)
            };
    
    private LinkedListStack<Object> stack;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp()
    {
        stack = new LinkedListStack<>();
    }

    private void fillStack(final Stack<Object> stack, final Object[] objs)
    {
        for (final Object obj : objs)
        {
            stack.push(obj);
        }
    }
    
    @Test
    public void twoEmptyStacks_theyShould_equal()
    {
        final Stack<Object> other = new ArrayStack<>();
     
        assertThat(stack, equalTo(other));
    }
    
    @Test
    public void twoStacksWithSameElement_theyShould_equal()
    {
        fillStack(stack, objs);
        
        final Stack<Object> other = new ArrayStack<>();
        fillStack(other, objs);
        
        assertThat(stack, equalTo(other));
    }
    
    @Test
    public void twoStacksWithSameElement_theyShould_haveSameHashCode()
    {
        fillStack(stack, objs);
        
        final Stack<Object> other = new ArrayStack<>();
        fillStack(other, objs);
        
        assertThat(stack.hashCode(), equalTo(other.hashCode()));
    }
    
    @Test
    public void stack_itShould_equalItself()
    {
        assertThat(stack, equalTo(stack));
    }
    
    @Test
    public void twoStacksOneHasMoreElement_theyShould_notEqual()
    {
        fillStack(stack, objs);
        
        final Stack<Object> other = new ArrayStack<>();
        final Object[] otherArray = Arrays.copyOf(objs, objs.length + 2);
        otherArray[objs.length] = new Object();
        otherArray[objs.length + 1] = new Date();
        
        fillStack(other, otherArray);
        
        assertThat(stack.equals(other), equalTo(false));
    }
    
    @Test
    public void twoSameSizeStacksOneHasDifferentElement_theyShould_notEqual()
    {
        fillStack(stack, objs);
        
        final Stack<Object> other = new ArrayStack<>();
        final Object[] otherArray = Arrays.copyOf(objs, objs.length);
        otherArray[objs.length - 1] = new Date();
        
        fillStack(other, otherArray);
        
        assertThat(stack.equals(other), equalTo(false));
    }
    
    @Test
    public void popEmptyStack_itShould_fail()
    {
        exception.expect(NoSuchElementException.class);
        
        stack.pop();
    }
    
    @Test
    public void peakEmptyStack_itShould_fail()
    {
        exception.expect(NoSuchElementException.class);
        
        stack.peak();
    }
    
    @Test
    public void peakStack_itShould_keepSame()
    {
        fillStack(stack, objs);
        
        assertThat(stack.peak(), equalTo(objs[objs.length - 1]));
        assertThat(stack.toArray(), equalTo(objs));
    }
    
    @Test
    public void multiplePeakStack_itShould_keepSame()
    {
        fillStack(stack, objs);
        
        assertThat(stack.peak(), equalTo(objs[objs.length - 1]));
        assertThat(stack.peak(), equalTo(objs[objs.length - 1]));
        assertThat(stack.peak(), equalTo(objs[objs.length - 1]));
        assertThat(stack.peak(), equalTo(objs[objs.length - 1]));
        assertThat(stack.peak(), equalTo(objs[objs.length - 1]));

        assertThat(stack.toArray(), equalTo(objs));
    }
    
    @Test
    public void pushOneElementToEmptyStack_itShould_getExpectedStack()
    {
        final Object obj = new Object();
        stack.push(obj);
        final Object[] dest = {obj};
        
        assertThat(stack.toArray(), equalTo(dest));
    }
    
    @Test
    public void pushMultipleElement_itShould_getExpectedStack()
    {
        fillStack(stack, objs);
        
        assertThat(stack.toArray(), equalTo(objs));
    }
    
    @Test
    public void popOneElement_itShould_getExpectedStack()
    {
        fillStack(stack, objs);
        assertThat(stack.pop(), equalTo(objs[objs.length - 1]));
        
        assertThat(stack.toArray(), equalTo(Arrays.copyOf(objs, objs.length - 1)));
    }
    
    @Test
    public void pushOneElementThenPop_itShould_getExpectedStack()
    {
        final Object obj = new Object();
        
        stack.push(obj);
        
        assertThat(stack.pop(), equalTo(obj));
        
        assertThat(stack.isEmpty(), equalTo(true));
    }
    
    @Test
    public void pushMultipleElementThenPop_itShould_getExpectedStack()
    {
        final Object obj1 = new Object();
        final Object obj2 = new Object();
        final Object obj3 = new Object();
        final Object obj4 = new Object();

        stack.push(obj1);
        stack.push(obj2);
        stack.push(obj3);
        stack.push(obj4);
        assertThat(stack.pop(), equalTo(obj4));
        assertThat(stack.pop(), equalTo(obj3));
        assertThat(stack.pop(), equalTo(obj2));
        assertThat(stack.pop(), equalTo(obj1));
        
        assertThat(stack.isEmpty(), equalTo(true));
    }
    
    @Test
    public void repeatPushMultipleElementThenPop_itShould_getExpectedStack()
    {
        final Object obj1 = new Object();
        final Object obj2 = new Object();
        final Object obj3 = new Object();
        final Object obj4 = new Object();

        stack.push(obj1);
        stack.push(obj2);
        assertThat(stack.pop(), equalTo(obj2));
        
        stack.push(obj3);
        assertThat(stack.pop(), equalTo(obj3));
        
        stack.push(obj4);
        assertThat(stack.pop(), equalTo(obj4));
        assertThat(stack.pop(), equalTo(obj1));
        
        assertThat(stack.isEmpty(), equalTo(true));
    }
    
    @Test
    public void popAllElements_itShould_getEmptyStack()
    {
        fillStack(stack, objs);
        for (int i = objs.length - 1; i >= 0; --i)
        {
            assertThat(stack.pop(), equalTo(objs[i]));
        }
        
        assertThat(stack.isEmpty(), equalTo(true));
    }
    
    @Test
    public void emptyStack_isEmptyShould_returnTrue()
    {
        assertThat(stack.isEmpty(), equalTo(true));
    }
    
    @Test
    public void singletonStack_isEmptyShould_returnTrue()
    {
        stack.push(new Object());
        
        assertThat(stack.isEmpty(), equalTo(false));
    }
    
    @Test
    public void stackWithMultipleElements_isEmptyShould_returnTrue()
    {
        fillStack(stack, objs);
        
        assertThat(stack.isEmpty(), equalTo(false));
    }
}
