package com.peter.left.demo;

public class BasicFindSumTargetPairs implements FindSumTargetPairs {
	@Override
	public void apply(int[] array, int targetValue) {
		for (int i = 0; i < array.length; ++i)
		{
			for (int j = i + 1; j < array.length; ++j)
			{
				if ((array[i] + array [j]) == targetValue)
				{
					System.out.printf("(%d, %d) \t", array[i], array[j]);
				}
			}
		}
	}
}
