package com.peter.left.interview.dataStructure.sort;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import static org.junit.Assert.assertThat;

public class BubbleSorterTest
{
    private Sorter<Integer> sorter;
    
    @Before
    public void setUp()
    {
        sorter = new BubbleSorter<>();
    }
    
    @Test
    public void emptyList_itShould_returnEmpty()
    {
        assertThat(sorter.sort(Collections.emptyList()), empty());
    }
    
    @Test
    public void singletonList_itShould_returnSingletonList()
    {
        assertThat(sorter.sort(Collections.singletonList(1)),
                equalTo(Collections.singletonList(1)));
    }
    
    @Test
    public void sortedList_itShould_returnSortedList()
    {
        final List<Integer> result = sorter.sort(Lists.newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        
        assertThat(result, equalTo(Lists.<Integer>newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }
    
    @Test
    public void reverseSortedList_itShould_returnSortedList()
    {
        final List<Integer> result = sorter.sort(Lists.newArrayList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
        
        assertThat(result, equalTo(Lists.<Integer>newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }
    
    @Test
    public void evenAndOddChangedList_itShould_returnSortedList()
    {
        final List<Integer> result = sorter.sort(Lists.newArrayList(1, 0, 3, 2, 5, 4, 7, 6, 9, 8));
        
        assertThat(result, equalTo(Lists.<Integer>newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }
    
    @Test
    public void twoPartChangedList_itShould_returnSortedList()
    {
        final List<Integer> result = sorter.sort(Lists.newArrayList(5, 6, 7, 8, 9, 0, 1, 2, 3, 4));
        
        assertThat(result, equalTo(Lists.<Integer>newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }
    
    @Test
    public void twoReversedPartChangedList_itShould_returnSortedList()
    {
        final List<Integer> result = sorter.sort(Lists.newArrayList(4, 3, 2, 1, 0, 9, 8, 7, 6, 5));
        
        assertThat(result, equalTo(Lists.<Integer>newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }
    
    @Test
    public void randomOrderList_itShould_returnSortedList()
    {
        final List<Integer> result = sorter.sort(Lists.newArrayList(9, 7, 4, 1, 0, 2, 3, 6, 5, 8));
        
        assertThat(result, equalTo(Lists.<Integer>newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }
    
    @Test
    public void allSameElmentsList_itShould_returnSortedList()
    {
        final List<Integer> result = sorter.sort(Lists.newArrayList(1, 1, 1, 1, 1, 1, 1, 1));
        
        assertThat(result, equalTo(Lists.<Integer>newArrayList(1, 1, 1, 1, 1, 1, 1, 1)));
    }
    
    @Test
    public void partSameElmentsList_itShould_returnSortedList()
    {
        final List<Integer> result = sorter.sort(Lists.newArrayList(9, 7, 0, 0, 0, 2, 3, 6, 5, 8));
        
        assertThat(result, equalTo(Lists.<Integer>newArrayList(0, 0, 0, 2, 3, 5, 6, 7, 8, 9)));
    }
}
