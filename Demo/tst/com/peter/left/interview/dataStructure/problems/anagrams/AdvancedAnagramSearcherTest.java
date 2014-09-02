package com.peter.left.interview.dataStructure.problems.anagrams;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.collect.Lists;

import static org.junit.Assert.assertThat;

public class AdvancedAnagramSearcherTest
{
    private AnagramSearcher<String> searcher;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp()
    {
        searcher = new AdvancedAnagramSearcher<>();
    }
    
    @Test
    public void nullWord_itShould_fail()
    {
        exception.expect(NullPointerException.class);
        
        searcher.search(Collections.emptyList(), null);
    }
    
    @Test
    public void nullWords_itShould_fail()
    {
        exception.expect(NullPointerException.class);
        
        searcher.search(null, String.valueOf(false));
    }
    
    @Test
    public void emptyWords_itShould_returnEmpty()
    {
        assertThat(
                searcher.search(Collections.emptyList(), String.valueOf(false)),
                empty());
    }
    
    @Test
    public void noAnagramInSingletionWords_itShould_returnEmpty()
    {
        assertThat(
                searcher.search(Collections.singletonList(String.valueOf(1)), String.valueOf(false)),
                empty());
    }
    
    @Test
    public void noAnagramsInMutipleWords_itShould_returnEmpty()
    {
        assertThat(
                searcher.search(Lists.newArrayList(String.valueOf(1), String.valueOf(true),
                        String.valueOf(2.0), new Date().toString()),
                        String.valueOf(false)),
                empty());
    }
    
    @Test
    public void sameWordInMutipleWords_itShould_returnCorrectList()
    {
        final List<String> result = searcher.search(Lists.newArrayList(String.valueOf(1), String.valueOf(true),
                String.valueOf(2.0), new Date().toString(), String.valueOf(false)),
                String.valueOf(false));
        assertThat(result, hasSize(1));
        assertThat(result, contains(String.valueOf(false)));
    }
    
    @Test
    public void singleAnagramWordInMutipleWords_itShould_returnCorrectList()
    {
        final List<String> result = searcher.search(Lists.newArrayList(String.valueOf(1), String.valueOf(true),
                String.valueOf(2.0), new Date().toString(), String.valueOf(false)),
                String.valueOf("fasle"));
        assertThat(result, hasSize(1));
        assertThat(result, contains(String.valueOf(false)));
    }
    
    @Test
    public void multipleAnagramWordInMutipleWords_itShould_returnCorrectList()
    {
        final List<String> result = searcher.search(Lists.newArrayList(String.valueOf(1), String.valueOf(true),
                String.valueOf(2.0), new Date().toString(), String.valueOf(false), String.valueOf("aflse"),
                String.valueOf("afles")),
                String.valueOf("fasle"));
        assertThat(result, hasSize(3));
        assertThat(result, contains(String.valueOf(false), String.valueOf("aflse"), String.valueOf("afles")));
    }
    
    @Test
    public void allWordsAreAnagram_itShould_returnCorrectList()
    {
        final List<String> source = Lists.newArrayList(String.valueOf("flase"), String.valueOf("eflsa"),
                String.valueOf("afels"), String.valueOf(false), String.valueOf("aflse"),
                String.valueOf("afles"));
        
        assertThat(searcher.search(source, String.valueOf(false)), equalTo(source));
    }
}
