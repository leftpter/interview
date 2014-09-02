package com.peter.left.interview.dataStructure.problems.reverseString;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class SimpleReverseStringTest
{
    private ReverseString<String> reverser;
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp()
    {
        reverser = new SimpleReverseString<>();
    }
    
    @Test
    public void nullString_itShould_fail()
    {
        exception.expect(NullPointerException.class);
        
        reverser.reverse(null);
    }
    
    @Test
    public void singleCharString_itShould_returnSame()
    {
        assertThat(reverser.reverse(String.valueOf(1)), equalTo(String.valueOf(1)));
    }
    
    @Test
    public void sameCharsString_itShould_returnSame()
    {
        assertThat(reverser.reverse(String.valueOf(11111111)), equalTo(String.valueOf(11111111)));
    }
    
    @Test
    public void MultipleCharsString_itShould_returnReverseString()
    {
        assertThat(reverser.reverse(String.valueOf("0123456789")), equalTo(String.valueOf("9876543210")));
    }
}
