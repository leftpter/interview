package com.peter.left.interview.dataStructure.problems.fibonacci;

import org.apache.commons.lang3.Validate;

public class IterativeFibonacci implements Fibonacci
{
    private long calculateFabonacci(final int n)
    {
        assert n > 2 : String.format("n must be larger than 2; is %d", n);
        
        long fn2 = 0;
        long fn1 = 1;
        long fn = 1;
        
        for (int i = 3; i <= n; ++i)
        {
            fn = fn2 + fn1;
            fn2 = fn1;
            fn1 = fn;
        }
            
        return fn;
    }
    
    @Override
    public long calculate(final int n)
    {
        Validate.isTrue(n > 0, "n must be positive; is %d", n);
        
        final long result;
        switch (n)
        {
            case 1:
                result = 0;
                break;
                
            case 2:
                result = 1;
                break;
                
            default:
                result = calculateFabonacci(n);
                break;
        }
        
        return result;
    }
}
