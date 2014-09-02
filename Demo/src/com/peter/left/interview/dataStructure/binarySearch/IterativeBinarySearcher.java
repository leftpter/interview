package com.peter.left.interview.dataStructure.binarySearch;

public class IterativeBinarySearcher<E extends Comparable<E>> implements BinarySearcher<E>
{
    @Override
    public int search(final E[] elements, final E element)
    {
        int index = -1;
        
        int left = 0;
        int right = elements.length;
        
        while (left < right)
        {
            final int middle = (left + right) / 2;
            
            final int compareResult = elements[middle].compareTo(element);
            
            if (compareResult == 0)
            {
                index = middle;
                break;
            }
            // In right part.
            else if (compareResult < 0)
            {
                left = middle + 1;
            }
            // In left part.
            else
            {
                right = middle;
            }
        }
        
        return index;
    }
}
