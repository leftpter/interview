package com.peter.left.interview.dataStructure.problems.CollapseIterators;

import static org.hamcrest.Matchers.equalTo;

import java.util.Collections;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import static org.junit.Assert.assertThat;

public class CollapseIteratorTest
{
    private CollapseIterator<Integer> iterator;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void nullList_hasNextShould_fail()
    {
        exception.expect(NullPointerException.class);
        
        CollapseIterator.createInstance(null);
    }
    
    @Test
    public void emptyList_hasNextShould_returnFalse()
    {
        iterator = CollapseIterator.createInstance(Collections.emptyList());
        
        assertThat(iterator.hasNext(), equalTo(false));
        assertThat(iterator.hasNext(), equalTo(false));
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void singleEmptyIteratorList_hasNextShould_returnFalse()
    {
        iterator = CollapseIterator.createInstance(Collections.singletonList(Iterators.emptyIterator()));
        
        assertThat(iterator.hasNext(), equalTo(false));
        assertThat(iterator.hasNext(), equalTo(false));
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void multipleEmptyIteratorsList_hasNextShould_returnFalse()
    {
        iterator = CollapseIterator.createInstance(
                Lists.newArrayList(Iterators.emptyIterator(), Iterators.emptyIterator(),
                        Iterators.emptyIterator(), Iterators.emptyIterator(),
                        Iterators.emptyIterator(), Iterators.emptyIterator(),
                        Iterators.emptyIterator(), Iterators.emptyIterator(),
                        Iterators.emptyIterator(), Iterators.emptyIterator()));
        
        assertThat(iterator.hasNext(), equalTo(false));
        assertThat(iterator.hasNext(), equalTo(false));
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void singleNoEmptyIteratorList_hasNextShould_returnTrue()
    {
        iterator = CollapseIterator.createInstance(
                Collections.singletonList(Iterators.singletonIterator(1)));
        
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.hasNext(), equalTo(true));
    }
    
    @Test
    public void singleNoEmptyWithMultipleEmptyIteratorsList_hasNextShould_returnTrue()
    {
        iterator = CollapseIterator.createInstance(
                Lists.newArrayList(Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.singletonIterator(1)));
        
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.hasNext(), equalTo(true));
    }
    
    @Test
    public void singleNoEmptyIteratorList_itShould_actAsExpected()
    {
        iterator = CollapseIterator.createInstance(
                Collections.singletonList(Iterators.singletonIterator(1)));
        
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(1));
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void singleNoEmptyWithMultipleEmptyIteratorsList_itShould_actAsExpected()
    {
        iterator = CollapseIterator.createInstance(
                Lists.newArrayList(Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.singletonIterator(1)));
        
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(1));
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void singleNoEmptyWithMixedEmptyIteratorsList_itShould_actAsExpected()
    {
        iterator = CollapseIterator.createInstance(
                Lists.newArrayList(Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.singletonIterator(1),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator()));
        
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(1));
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void MultipleNoEmptyWithMultipleEmptyIteratorsList_itShould_actAsExpected()
    {
        iterator = CollapseIterator.createInstance(
                Lists.newArrayList(Iterators.singletonIterator(2),
                        Iterators.singletonIterator(3),
                        Iterators.singletonIterator(1)));
        
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(2));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(3));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(1));
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void MultipleNoEmptyWithMixedEmptyIteratorsList_itShould_actAsExpected()
    {
        iterator = CollapseIterator.createInstance(
                Lists.newArrayList(Iterators.singletonIterator(2),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.singletonIterator(3),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.singletonIterator(1)));
        
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(2));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(3));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(1));
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void singleIteratorList_itShould_actAsExpected()
    {
        iterator = CollapseIterator.createInstance(
                Collections.singletonList(Lists.newArrayList(2, 3, 1).iterator()));
        
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(2));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(3));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(1));
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void singleIteratorWithMixedEmptyIteratosList_itShould_actAsExpected()
    {
        iterator = CollapseIterator.createInstance(
                Lists.newArrayList(Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Lists.newArrayList(2, 3, 1).iterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator()));
        
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(2));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(3));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(1));
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void multipleIteratorsWithMixedEmptyIteratosList_itShould_actAsExpected()
    {
        iterator = CollapseIterator.createInstance(
                Lists.newArrayList(Lists.newArrayList(6, 4, 1).iterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator(),
                        Lists.newArrayList(2, 3, 1).iterator(),
                        Iterators.emptyIterator(),
                        Iterators.emptyIterator()));
        
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(6));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(4));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(1));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(2));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(3));
        assertThat(iterator.hasNext(), equalTo(true));
        assertThat(iterator.next(), equalTo(1));
        assertThat(iterator.hasNext(), equalTo(false));
    }
}
