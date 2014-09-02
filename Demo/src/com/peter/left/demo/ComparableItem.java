package com.peter.left.demo;

public class ComparableItem implements Comparable<ComparableItem> {
	private final double value;
	
	public ComparableItem(final double value) {
		this.value = value;
	}

	@Override
	public int compareTo(final ComparableItem o) {
		// TODO Auto-generated method stub
		return Double.compare(value, o.value);
	}
}
