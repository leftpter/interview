package com.peter.left.demo;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorItem implements Comparator<ComparatorItem> {
	private final double value;
	
	public ComparatorItem(final double value) {
		this.value = value;
	}
	
	@Override
	public int compare(final ComparatorItem o1, final ComparatorItem o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.value, o2.value);
	}

}
