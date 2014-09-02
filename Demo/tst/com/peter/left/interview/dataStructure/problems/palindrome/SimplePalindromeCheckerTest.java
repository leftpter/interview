package com.peter.left.interview.dataStructure.problems.palindrome;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class SimplePalindromeCheckerTest
{
    private PalindromeChecker<String> checker;
    
    @Before
    public void setUp()
    {
        checker = new SimplePalindromeChecker<>();
    }
    
    @Test
    public void nullString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(null), equalTo(true));
    }
    
    @Test
    public void emptyString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(""), equalTo(true));
    }
    
    @Test
    public void singletonString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome("w"), equalTo(true));
    }
    
    @Test
    public void stringOnlyHasNoLetters_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(" .@@@#####$$$$$$$$$%%%%%%%%%"), equalTo(true));
    }
    
    @Test
    public void singletonCharWithNoneLetterString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("          .#      w")), equalTo(true));
    }
    
    @Test
    public void stringOnlyHasSameChars_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("wwwwwwwwwwwwwwwww")), equalTo(true));
    }
    
    @Test
    public void sameCharsWithNoneLetterString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("  w        w w.#####      w")), equalTo(true));
    }
    
    @Test
    public void palindromeWithEvenNumberLetterWithoutNoneLetterString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("wsdaadsw")), equalTo(true));
    }
    
    @Test
    public void palindromeWithOddNumberLetterWithoutNoneLetterString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("wsdadsw")), equalTo(true));
    }
    
    @Test
    public void palindromeWithEvenNumberLetterWithNoneLetterString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("w    s d a#####ad@@@@@@s w      ")), equalTo(true));
    }
    
    @Test
    public void palindromeWithOddNumberLetterWithNoneLetterString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("w  @@@ s # d&&a d %% s ))) w   ")), equalTo(true));
    }
    
    @Test
    public void palindromeUpDownCaseWithEvenNumberLetterWithoutNoneLetterString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("wSdAaDsW")), equalTo(true));
    }
    
    @Test
    public void palindromeUpDownCaseWithOddNumberLetterWithoutNoneLetterString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("WsDadSw")), equalTo(true));
    }
    
    @Test
    public void palindromeUpDownCaseWithEvenNumberLetterWithNoneLetterString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("w    S d A#####aD@@@@@@s W      ")), equalTo(true));
    }
    
    @Test
    public void palindromeUpDownCaseWithOddNumberLetterWithNoneLetterString_itShould_returnTrue()
    {
        assertThat(checker.isPalindrome(String.valueOf("W  @@@ s # D&&a d %% S ))) w   ")), equalTo(true));
    }
    
    @Test
    public void NoPalindromeWithEvenNumberLetterWithoutNoneLetterString_itShould_returnFalse()
    {
        assertThat(checker.isPalindrome(String.valueOf("waww")), equalTo(false));
    }
    
    @Test
    public void NoPalindromeWithOddNumberLetterWithoutNoneLetterString_itShould_returnFalse()
    {
        assertThat(checker.isPalindrome(String.valueOf("wsdatdsw")), equalTo(false));
    }
    
    @Test
    public void palindromeWithOddNumberLetterWithoutNoneLetterString_itShould_returnFalse()
    {
        assertThat(checker.isPalindrome(String.valueOf("wsdatsw")), equalTo(false));
    }
    
    @Test
    public void palindromeWithEvenNumberLetterWithNoneLetterString_itShould_returnFalse()
    {
        assertThat(checker.isPalindrome(String.valueOf("w    s d a#####td@@@@@@s w      ")), equalTo(false));
    }
    
    @Test
    public void palindromeWithOddNumberLetterWithNoneLetterString_itShould_returnFalse()
    {
        assertThat(checker.isPalindrome(String.valueOf("w  @@@ s # d&&a t %% s ))) w   ")), equalTo(false));
    }
}
