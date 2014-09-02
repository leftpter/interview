package com.peter.left.interview.dataStructure.binarySearch;

public class RecursionBinarySearcher<E extends Comparable<E>> implements BinarySearcher<E>
{
    private int binarySearch(final E[] elements, 
            final int startPos, final int endPos, final E element)
    {
        final int index;
        
        if (startPos < endPos)
        {
            final int middlePos = (startPos + endPos) / 2;
            
            final int compareResult = elements[middlePos].compareTo(element);
            
            if (compareResult == 0)
            {
                index = middlePos;
            }
            // In the right part.
            else if (compareResult < 0)
            {
                index = binarySearch(elements, middlePos + 1, endPos, element);
            }
            // In the left part.
            else
            {
                index = binarySearch(elements, startPos, middlePos, element);
            }
        }
        else
        {
            index = -1;
        }
        
        return index;
    }
    @Override
    public int search(final E[] elements, final E element)
    {
        return binarySearch(elements, 0, elements.length, element);
    }
}
