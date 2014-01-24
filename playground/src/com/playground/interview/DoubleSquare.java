package com.playground.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kmohan
 */
public class DoubleSquare {

	public static Set<String> calculate(int input) {
		int sqrt = (int) Math.sqrt(input);

		int j, k;
		double d;
		Set<String> result = new HashSet<String>();
		for (int i = 0; i <= sqrt; i++) {
			j = (int) Math.pow(i, 2);
			d = Math.sqrt(input - j);
			k = (int) Math.sqrt(input - j);
			if (d - k == 0) {
				// then we got a pair
				if (i < k) {
					result.add("(" + i + "," + k + ")");
				} else {
					result.add("(" + k + "," + i + ")");
				}
			}
		}
		return result;
	}
}
