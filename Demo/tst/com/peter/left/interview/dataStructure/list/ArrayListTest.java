package com.peter.left.interview.dataStructure.list;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ArrayListTest
{
    private ArrayList<Object> list;
    private Object[] objs = {new Object(), Boolean.valueOf(true), Integer.valueOf(20),
            String.valueOf("xccxzxxd"), Long.valueOf(Long.MAX_VALUE),
            Double.valueOf(Double.MIN_NORMAL), null};
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp()
    {
        list = new ArrayList<>();
    }
    
    private void fillListsWithMultipleElements(final List<Object> list)
    {
        for (final Object obj : objs)
        {
            list.add(obj);
        }
    }
    
    @Test
    public void addOneElementToEmptyList_itShould_getOneElementList()
    {
        final Object obj = new Object();
        list.add(obj);
        assertThat(list, equalTo(Collections.singletonList(obj)));
    }
    
    @Test
    public void addMultipleElementsToEmptyList_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        assertThat(list, equalTo(Arrays.asList(objs)));
    }
    
    @Test
    public void setMultipleElements_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {new Object(){private final int a = 0;}, 
                objs[1], objs[2], String.valueOf("xccxzxxd"), objs[4], objs[5], Integer.valueOf(20)};
        
        assertThat(list.set(3, resultObjs[3]), equalTo(objs[3]));
        
        assertThat(list.set(0, resultObjs[0]), equalTo(objs[0]));
        
        assertThat(list.set(list.size() - 1, resultObjs[resultObjs.length - 1]),
                equalTo(objs[objs.length - 1]));
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void removeMultipleElements_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {objs[1], objs[2], objs[4], objs[5]};
        
        assertThat(list.remove(3), equalTo(objs[3]));
        assertThat(list.remove(0), equalTo(objs[0]));
        assertThat(list.remove(list.size() - 1), equalTo(objs[objs.length - 1]));
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void multipleElements_iteratorShould_actAsStandardList()
    {
        fillListsWithMultipleElements(list);
        
        final List<Object> standardList = Lists.newArrayList();
        fillListsWithMultipleElements(standardList);
        
        final Iterator<Object> iterator = list.iterator();
        for (final Iterator<Object> standardIterator = standardList.iterator();
                standardIterator.hasNext();)
        {
            assertThat(iterator.hasNext(), equalTo(true));
            assertThat(iterator.next(), equalTo(standardIterator.next()));
        }
        
        assertThat(iterator.hasNext(), equalTo(false));
    }
    
    @Test
    public void iteratorRemoveHeadElements_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {objs[1], objs[2], objs[3], objs[4], objs[5], objs[6]};
        
        removeElement(0, list.iterator());
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void addElementAtHead_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {new Object(), 
                objs[0], objs[1], objs[2], objs[3], objs[4], objs[5], objs[6]};
        
        list.add(0, resultObjs[0]);
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void addElementAtTail_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {objs[0], objs[1], objs[2],
                objs[3], objs[4], objs[5], objs[6], new Object()};
        
        list.add(list.size(), resultObjs[resultObjs.length - 1]);
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void addElementAtMiddle_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {objs[0], objs[1], objs[2],
                new Object(), objs[3], objs[4], objs[5], objs[6]};
        
        list.add(3, resultObjs[3]);
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void addMutipleElement_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {new Object(), objs[0], objs[1], objs[2],
                new Object(), new Object(), objs[3], objs[4], objs[5], objs[6],
                new Object()};
        
        list.add(3, resultObjs[5]);
        list.add(3, resultObjs[4]);
        list.add(0, resultObjs[0]);
        list.add(list.size(), resultObjs[resultObjs.length - 1]);
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void iteratorRemoveTailElements_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {objs[0], objs[1], objs[2], objs[3], objs[4], objs[5]};
        
        removeElement(list.size() - 1, list.iterator());
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void iteratorRemoveMiddleElements_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {objs[0], objs[1], objs[2], objs[4], objs[5], objs[6]};                
        
        removeElement(3, list.iterator());
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void iteratorRemoveMultipleElements_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {objs[1], objs[2], objs[5]};
        
        removeElement(4, list.iterator());
        removeElement(3, list.iterator());
        removeElement(0, list.iterator());
        removeElement(list.size() - 1, list.iterator());
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void sameIteratorRemoveMultipleElements_itShould_getExceptedList()
    {
        fillListsWithMultipleElements(list);
        
        final Object[] resultObjs = {objs[1], objs[2], objs[5]};
        
        final HashSet<Integer> removeElements = Sets.newHashSet();
        removeElements.add(0);
        removeElements.add(3);
        removeElements.add(4);
        removeElements.add(list.size() - 1);
        
        int index = 0;
        
        for (final Iterator<Object> iterator = list.iterator();
                iterator.hasNext(); ++index)
        {
            assertThat(iterator.next(), equalTo(objs[index]));
            if (removeElements.contains(index))
            {
                iterator.remove();
            }
        }
        
        assertThat(list, equalTo(Arrays.asList(resultObjs)));
    }
    
    @Test
    public void getElementFromEmptyList_itShould_Fail()
    {
        exception.expect(IndexOutOfBoundsException.class);
        
        list.get(0);
    }
    
    @Test
    public void getElementBeforeListHead_itShould_Fail()
    {
        fillListsWithMultipleElements(list);
        
        exception.expect(IndexOutOfBoundsException.class);
        
        list.get(-1);
    }
    
    @Test
    public void getElementAfterListTail_itShould_Fail()
    {
        fillListsWithMultipleElements(list);
        
        exception.expect(IndexOutOfBoundsException.class);
        
        list.get(list.size());
    }
    
    @Test
    public void addElementBeforeListHead_itShould_Fail()
    {
        fillListsWithMultipleElements(list);
        
        exception.expect(IndexOutOfBoundsException.class);
        
        list.add(-1, exception);
    }
    
    @Test
    public void addElementAfterListTail_itShould_Fail()
    {
        fillListsWithMultipleElements(list);
        
        exception.expect(IndexOutOfBoundsException.class);
        
        list.add(list.size() + 1, exception);
    }
    
    @Test
    public void setElementBeforeListHead_itShould_Fail()
    {
        fillListsWithMultipleElements(list);
        
        exception.expect(IndexOutOfBoundsException.class);
        
        list.set(-1, exception);
    }
    
    @Test
    public void setElementAfterListTail_itShould_Fail()
    {
        fillListsWithMultipleElements(list);
        
        exception.expect(IndexOutOfBoundsException.class);
        
        list.set(list.size(), exception);
    }
    
    @Test
    public void removeElementBeforeListHead_itShould_Fail()
    {
        fillListsWithMultipleElements(list);
        
        exception.expect(IndexOutOfBoundsException.class);
        
        list.remove(-1);
    }
    
    @Test
    public void removeElementAfterListTail_itShould_Fail()
    {
        fillListsWithMultipleElements(list);
        
        exception.expect(IndexOutOfBoundsException.class);
        
        list.remove(list.size());
    }
    
    @Test
    public void removeElementByIteratorBeforeNext_itShould_Fail()
    {
        fillListsWithMultipleElements(list);
        final Iterator<Object> iterator = list.iterator();

        exception.expect(IllegalStateException.class);
        
        iterator.remove();
    }
    
    @Test
    public void dupliatedRemoveElementByIteratorAfterOneNext_itShould_Fail()
    {
        fillListsWithMultipleElements(list);
        final Iterator<Object> iterator = list.iterator();
        iterator.next();
        iterator.remove();
        
        exception.expect(IllegalStateException.class);
        
        iterator.remove();
    }
    
    @Test
    public void iteratorNextAtTail_itShould_Fail()
    {
        final Iterator<Object> iterator = list.iterator();

        exception.expect(NoSuchElementException.class);
        
        iterator.next();
    }
    
    private <T> void removeElement(final int index, final Iterator<T> iterator)
    {
        for (int i = 0; i <= index; ++i)
        {
            if (iterator.hasNext())
            {
                iterator.next();
            }
            else
            {
                throw new NoSuchElementException(
                        String.format("expected to remove %dth element, the length of iterable is %d",
                                index, i));
            }
        }
        
        iterator.remove();
    }
}
