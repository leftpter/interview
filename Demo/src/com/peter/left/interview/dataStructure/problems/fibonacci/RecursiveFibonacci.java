package com.peter.left.interview.dataStructure.problems.fibonacci;

import org.apache.commons.lang3.Validate;

public class RecursiveFibonacci implements Fibonacci
{
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
                result = calculate(n - 2) + calculate(n - 1);
                break;
        }
        
        return result;
    }
}
