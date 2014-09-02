package com.peter.left.interview.dataStructure.problems.palindrome;

public class SimplePalindromeChecker<E extends CharSequence> implements PalindromeChecker<E>
{
    @Override
    public boolean isPalindrome(final E charSequence)
    {
        boolean bRet = true;
        
        if (null != charSequence)
        {
            int left = 0;
            int right = charSequence.length() - 1;
            
            while (left < right)
            {
                while (left < charSequence.length() &&
                        !Character.isLetter(charSequence.charAt(left)))
                {
                    ++left;
                }
                
                while (right >= 0 && !Character.isLetter(charSequence.charAt(right)))
                {
                    --right;
                }
                
                if (left >= right)
                {
                    break;
                }
                else
                {
                    if (Character.toLowerCase(charSequence.charAt(left++)) !=
                            Character.toLowerCase(charSequence.charAt(right--)))
                    {
                        bRet = false;
                        break;
                    }
                }
            }
        }
        
        return bRet;
    }
}
