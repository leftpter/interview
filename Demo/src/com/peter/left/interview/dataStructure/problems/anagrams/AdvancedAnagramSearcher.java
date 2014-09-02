package com.peter.left.interview.dataStructure.problems.anagrams;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class AdvancedAnagramSearcher<E extends CharSequence> implements AnagramSearcher<E>
{
    private Map<Character, Integer> getCharactersMap(final E characters)
    {
        final Map<Character, Integer> map = Maps.newHashMap();
        
        if (null != characters)
        {
            for (int i = 0; i < characters.length(); ++i)
            {
                final char character = characters.charAt(i);
                
                if (map.containsKey(character))
                {
                    map.put(character, map.get(character) + 1);
                }
                else
                {
                    map.put(character, 1);
                }
            }
        }
        
        return map;
    }
    
    @Override
    public List<E> search(final List<E> words, final E word)
    {
        Validate.notNull(words, "words must not be null");
        Validate.notNull(word, "word must not be null");
        
        final List<E> anagrams = Lists.newArrayList();
        
        final Map<Character, Integer> standard = getCharactersMap(word);
        
        Consumer<E> consumer = (s)-> {
            if (standard.equals(getCharactersMap(s)))
            {
                anagrams.add(s);
            }
        };
        
        words.forEach(consumer);
        
        return anagrams;
    }
}
