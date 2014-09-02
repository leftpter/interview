package com.peter.left.interview.dataStructure.problems.factorial;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class IterativeFactorialTest
{
    private Factorial factorial;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp()
    {
        factorial = new IterativeFactorial();
    }
    
    @Test
    public void negative_itShould_fail()
    {
        exception.expect(IllegalArgumentException.class);
        
        factorial.calculate(-1);
    }
    
    @Test
    public void zero_itShould_fail()
    {
        exception.expect(IllegalArgumentException.class);
        
        factorial.calculate(0);
    }
    
    @Test
    public void one_itShould_return1()
    {
        assertThat(factorial.calculate(1), equalTo(1l));
    }
    
    @Test
    public void two_itShould_return2()
    {
        assertThat(factorial.calculate(2), equalTo(2l));
    }
    
    @Test
    public void three_itShould_return6()
    {
        assertThat(factorial.calculate(3), equalTo(6l));
    }
    
    @Test
    public void nice_itShould_return362880()
    {
        assertThat(factorial.calculate(9), equalTo(362880l));
    }
}
