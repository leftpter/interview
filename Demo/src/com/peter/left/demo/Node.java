package com.peter.left.demo;

import org.apache.commons.lang3.Validate;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Node implements Comparable<Node> {
	
	private final int x;
	private final int y;
	private final double value;
	
	public Node(final int x, final int y, final double value) {
		Validate.isTrue(0 <= x, "x must not be negative; is %d", x);
		Validate.isTrue(0 <= y, "y must not be negative; is %d", y);
		Validate.isTrue(0 <= value, "value must not be negative; is %f", value);
		
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getValue() {
		return value;
	}

	@Override
	public int compareTo(final Node other) {
		Validate.notNull(other, "other must not be null");

		return Double.compare(value, other.value);
	}
}
