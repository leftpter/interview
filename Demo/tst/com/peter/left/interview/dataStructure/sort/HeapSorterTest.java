package com.peter.left.interview.dataStructure.sort;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.peter.left.interview.dataStructure.heap.Heap;


public class HeapSorterTest
{
    private Mockery context;
    private Heap<Integer> heap;
    private Sorter<Integer> sorter;
    
    @SuppressWarnings("unchecked")
    @Before
    public void setUp()
    {
        context = new JUnit4Mockery();
        
        heap = (Heap<Integer>) context.mock(Heap.class);
        
        sorter = new HeapSorter<>(heap);
    }
    
    @After
    public void tearDown()
    {
        context.assertIsSatisfied();
    }
    
    @Test
    public void singletonList_itShould_actAsExpected()
    {
        final Integer item = Integer.valueOf(1);
        final List<Integer> list = Collections.singletonList(item);

        context.checking(new Expectations() {{
            oneOf(heap).clear();
            
            oneOf(heap).push(with(same(item)));

            oneOf(heap).isEmpty();
            will(returnValue(false));
            
            oneOf(heap).pop();
            will(returnValue(item));
            
            oneOf(heap).isEmpty();
            will(returnValue(true));
        }});
        
        assertThat(sorter.sort(list), equalTo(Collections.singletonList(item)));
    }
    
    @Test
    public void multipleElementsList_itShould_actAsExpected()
    {
        final Integer[] elements = {
                Integer.valueOf(0), Integer.valueOf(1),
                Integer.valueOf(2), Integer.valueOf(3),
                Integer.valueOf(4), Integer.valueOf(5),
                Integer.valueOf(6), Integer.valueOf(7),
                Integer.valueOf(8), Integer.valueOf(9),
        };
        
        final List<Integer> list = Lists.newArrayList(elements);

        final Sequence pop = context.sequence("isEmptyThenPop");
        
        for (final Integer element : list)
        {
            context.checking(new Expectations() {{
                oneOf(heap).push(with(same(element)));
            }});
        }
        
        final List<Integer> result = Lists.newArrayList(elements);
        Collections.reverse(result);
        
        for (final Integer element : result)
        {
            context.checking(new Expectations() {{
                oneOf(heap).isEmpty();
                will(returnValue(false));
                
                oneOf(heap).pop();
                will(returnValue(element));
            }});
        }
        
        context.checking(new Expectations() {{
            oneOf(heap).isEmpty();
            will(returnValue(true));
            
            oneOf(heap).clear();
        }});
        
        assertThat(sorter.sort(list), equalTo(result));
    }
}
