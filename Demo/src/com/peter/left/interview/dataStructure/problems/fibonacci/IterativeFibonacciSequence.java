package com.peter.left.interview.dataStructure.problems.fibonacci;

import java.util.List;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Lists;

public class IterativeFibonacciSequence implements FibonacciSequence
{
    private void addFibonacciToList(final List<Long> fibos, final int n)
    {
        if (1 == n)
        {
            fibos.add(0l);
        }
        else if (2 == n)
        {
            fibos.add(1l);
        }
        else
        {
            final long last = fibos.get(fibos.size() - 2) + fibos.get(fibos.size() - 1);
            
            fibos.add(last);
        }
    }
    
    @Override
    public List<Long> calculate(final int n)
    {
        Validate.isTrue(n >= 0, "n must not be negative; is %d", n);
     
        final List<Long> fibos = Lists.newArrayListWithCapacity(n);
        
        for (int i = 1; i <= n; ++i)
        {
            addFibonacciToList(fibos, i);
        }
        
        return fibos;
    }
}
