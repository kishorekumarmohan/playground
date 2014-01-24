package com.playground.interview;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class DoubleSquareTest {

	@Test
	public void test() {
		int input = (int) (Math.random() * 100);
		input = (int) Math.pow(input, 2);
		Set<String> result = DoubleSquare.calculate(input);
		assertNotNull(result);
		System.out.println("Input = " +input + "; Double squares are " +result);
	}
}
