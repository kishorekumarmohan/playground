package com.playground.interview;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author kmohan
 */
public class DenominationsTest {

	@Test
	public void test() {
		Denominations d = new Denominations();
		int input, output;
		List<Integer> result;
		for (int i = 0; i <= 100; i++) {
			input = (int) (Math.random() * 1000);
			output = 0;
			result = new ArrayList<Integer>();
			result = d.calculate(input, 0);
			for (int j : result) {
				output = output + j;
			}
			Assert.assertTrue(output == input);
			System.out.println("Input = " + input + "; Denominations = " + result);
		}
	}
}
