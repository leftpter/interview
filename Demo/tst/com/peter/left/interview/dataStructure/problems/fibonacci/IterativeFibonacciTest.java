package com.peter.left.interview.dataStructure.problems.fibonacci;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class IterativeFibonacciTest
{
    private Fibonacci fibo;
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp()
    {
        fibo = new IterativeFibonacci();
    }
    
    @Test
    public void negative_itShould_fail()
    {
        exception.expect(IllegalArgumentException.class);
        
        fibo.calculate(-1);
    }
    
    @Test
    public void zero_itShould_fail()
    {
        exception.expect(IllegalArgumentException.class);
        
        fibo.calculate(0);
    }
    
    @Test
    public void one_itShould_return0()
    {
        assertThat(fibo.calculate(1), equalTo(0l));
    }
    
    @Test
    public void two_itShould_return1()
    {
        assertThat(fibo.calculate(2), equalTo(1l));
    }
    
    @Test
    public void three_itShould_return1()
    {
        assertThat(fibo.calculate(3), equalTo(1l));
    }
    
    @Test
    public void eight_itShould_return13()
    {
        assertThat(fibo.calculate(8), equalTo(13l));
    }
}
