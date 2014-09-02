package com.peter.left.interview.dataStructure.problems.factorial;

import org.apache.commons.lang3.Validate;

public class IterativeFactorial implements Factorial
{
    long calculateFactorial(final int n)
    {
        assert n > 0 : String.format("n must be positve; is %d", n);
        
        long fn = 1;
        long fn1 = 1;
        
        for (int i = 1; i <= n; ++i)
        {
            fn = fn1 * i;
            fn1 = fn;
        }
        
        return fn;
    }
    
    @Override
    public long calculate(final int n)
    {
        Validate.isTrue(n > 0, "n must be positive; is %d", n);
        
        return calculateFactorial(n);
    }
}
