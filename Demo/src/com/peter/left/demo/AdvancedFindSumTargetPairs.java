package com.peter.left.demo;

import java.util.Set;

import com.google.common.collect.Sets;

public class AdvancedFindSumTargetPairs implements FindSumTargetPairs {
	@Override
	public void apply(final int[] array, final int targetValue) {
		final Set<Integer> otherValues = Sets.newHashSet();
		for (final int value : array) {
			if (otherValues.contains(value))
			{
				System.out.printf("(%d , %d)\t", targetValue - value, value);
			}
			else
			{
				otherValues.add(targetValue - value);
			}
		}
	}
}
