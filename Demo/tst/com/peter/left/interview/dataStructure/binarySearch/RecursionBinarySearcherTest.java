package com.peter.left.interview.dataStructure.binarySearch;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class RecursionBinarySearcherTest
{
    private BinarySearcher<Integer> searcher;
    private Integer[] elements = {0, 1, 2, 3, 4, 6, 7, 8, 9};
    private Integer[] goodElements = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    @Before
    public void setUp()
    {
        searcher = new RecursionBinarySearcher<>();
    }
    
    @Test
    public void searchElementInEmptyArray_itShould_returnNegativeOne()
    {
        assertThat(searcher.search(new Integer[0], 2), equalTo(-1));
    }
    
    @Test
    public void searchElementLessThanAllElements_itShould_returnNegativeOne()
    {
        assertThat(searcher.search(elements, -1), equalTo(-1));
    }
    
    @Test
    public void searchElementLargerThanAllElements_itShould_returnNegativeOne()
    {
        assertThat(searcher.search(elements, 10), equalTo(-1));
    }
    
    @Test
    public void searchElementMiddleInAllElements_itShould_returnNegativeOne()
    {
        assertThat(searcher.search(elements, 5), equalTo(-1));
    }
    
    @Test
    public void searchFirstElement_itShould_return0()
    {
        assertThat(searcher.search(goodElements, 0), equalTo(0));
    }
    
    @Test
    public void searchLastElement_itShould_returnCorrectIndex()
    {
        assertThat(searcher.search(goodElements, 9), equalTo(9));
    }
    
    @Test
    public void searchMiddleElement_itShould_returnCorrectIndex()
    {
        assertThat(searcher.search(goodElements, 5), equalTo(5));
    }
    
    @Test
    public void searchAllElements_itShould_returnCorrectIndex()
    {
        for (int i = 0; i < elements.length; ++i)
        {
            assertThat(searcher.search(goodElements, i), equalTo(i));
        }
    }
}
