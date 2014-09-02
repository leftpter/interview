package com.peter.left.interview.dataStructure.sort;

import java.util.List;

public class SimplePivotFinder<E extends Comparable<E>> implements PivotFinder<E>
{
    @Override
    public int find(final List<E> list, final int startPos, final int endPos)
    {
        final E firstValue = list.get(startPos);
        int index = -1;
        
        for (int i = startPos + 1; i <= endPos; ++i)
        {
            if (list.get(i).compareTo(firstValue) > 0)
            {
                index = i;
                break;
            }
            else if (list.get(i).compareTo(firstValue) < 0)
            {
                index = startPos;
                break;
            }
        }
        
        return index;
    }
}
