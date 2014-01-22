package com.playground.interview;

import static org.junit.Assert.assertNotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Test;

public class DollarAmountInWordsTest {

	@Test
	public void test() {
		DollarAmountInWords dollarAmountInWords = new DollarAmountInWords();

		for (int i = 0; i < 100; i++) {
			double d = Math.random() * 8897333334L;
			NumberFormat nf = DecimalFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			String input = nf.format(d);
			String output = dollarAmountInWords.amountToWords(input);
			System.out.println(input + " = " + output);
			assertNotNull(output);
		}
	}
}
