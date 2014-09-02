package com.peter.left.demo;

import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.Sets;

public class Demo {

	private <T> void test(T... args) {
		System.out.println(args.getClass().getName());
		for (T arg : args) {
			System.out.println(arg.getClass().getName());
		}
	}
	
	public static void main(String[] args) {
		final int[] array = {1, 2, 3, 0, -1, -2, -3};
		FindSumTargetPairs finder = new AdvancedFindSumTargetPairs();
		finder.apply(array, 0);
	}
}
