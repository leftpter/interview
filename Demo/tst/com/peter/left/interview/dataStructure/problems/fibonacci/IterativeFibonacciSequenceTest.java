package com.peter.left.interview.dataStructure.problems.fibonacci;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

import java.util.Collections;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.collect.Lists;

import static org.junit.Assert.assertThat;


public class IterativeFibonacciSequenceTest
{
    private FibonacciSequence fibo;
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp()
    {
        fibo = new IterativeFibonacciSequence();
    }
    
    @Test
    public void negativeValue_itShould_failToCalculate()
    {
        exception.expect(IllegalArgumentException.class);
        
        fibo.calculate(-1);
    }
    
    @Test
    public void zero_itShould_returnEmptyList()
    {
        assertThat(fibo.calculate(0), empty());
    }
    
    @Test
    public void one_itShould_returnSingletonList()
    {
        assertThat(fibo.calculate(1), equalTo(Collections.singletonList(0l)));
    }
    
    @Test
    public void two_itShould_returnCorrectList()
    {
        assertThat(fibo.calculate(2), equalTo(Lists.newArrayList(0l, 1l)));
    }
    
    @Test
    public void three_itShould_returnCorrectList()
    {
        assertThat(fibo.calculate(3), equalTo(Lists.newArrayList(0l, 1l, 1l)));
    }
    
    @Test
    public void eight_itShould_returnCorrectList()
    {
        assertThat(fibo.calculate(8), equalTo(Lists.newArrayList(0l, 1l, 1l, 2l, 3l, 5l, 8l, 13l)));
    }
}
