package com.peter.left.interview.dataStructure.problems.reverseString;

import org.apache.commons.lang3.Validate;

public class SimpleReverseString<E extends CharSequence> implements ReverseString<E>
{
    @Override
    public String reverse(final E string)
    {
        Validate.notNull(string, "string must not be null");
        
        final StringBuilder result = new StringBuilder(string.length());
        
        for (int i = string.length() - 1; i >= 0; --i)
        {
            result.append(string.charAt(i));
        }
        
        return result.toString();
    }
}
