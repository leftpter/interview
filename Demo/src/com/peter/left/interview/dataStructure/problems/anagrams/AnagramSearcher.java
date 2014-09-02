package com.peter.left.interview.dataStructure.problems.anagrams;

import java.util.List;

/**
 * Search all anagrams of given word in the given collection.
 *
 * @param <E> CharSequence to express the word.
 */
public interface AnagramSearcher<E extends CharSequence>
{
    /**
     * Search all anagrams of {@code word} in {@code words}
     * @param words collection of words.
     * @param word word for anagram.
     * @return Collection of anagram of {@code word} in {@code words}.
     */
    List<E> search(List<E> words, E word);
}
