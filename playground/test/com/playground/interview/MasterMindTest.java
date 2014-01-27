package com.playground.interview;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MasterMindTest {

	MasterMind mm;

	@Before
	public void setUp() throws Exception {
		mm = new MasterMind();
	}

	@Test
	public void testCodeMaker() {
		Map<String, String> codes = new HashMap<String, String>();
		for (int i = 0; i < 10; i++) {
			String key = new String(mm.codeMaker());
			if (!codes.containsKey(key)) {
				codes.put(key, "");
			} else {
				Assert.fail();
			}
		}
	}

	@Test
	public void testCodeBreaker() {
		char[] code = { 'G', 'Y', 'Y', 'B' };

		String[][] expectedResult = { { "GYYY", "3", "0" }, { "RBYG", "1", "2" }, { "GYYB", "4", "0" } };

		System.out.println(expectedResult.length);
		for (int i = 0; i < expectedResult.length; i++) {
			String input = expectedResult[i][0];
			int[] actualResult = mm.codeBreaker(input.toCharArray(), code);

			System.out.println("Expected " + Integer.parseInt(expectedResult[i][1]) + " - " + Integer.parseInt(expectedResult[i][2]));
			System.out.println("Actual " + actualResult[0] + " - " + actualResult[1]);

			Assert.assertTrue(actualResult[0] == Integer.parseInt(expectedResult[i][1]));
			Assert.assertTrue(actualResult[1] == Integer.parseInt(expectedResult[i][2]));
		}
	}

	@After
	public void tearDown() throws Exception {
		mm = null;
	}
}
