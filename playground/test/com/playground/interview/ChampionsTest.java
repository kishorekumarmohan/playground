package com.playground.interview;

import org.junit.Assert;
import org.junit.Test;

public class ChampionsTest {
	@Test
	public void testFindChampions() {
		Champions c = new Champions();

		int noOfTests = 10;
		int[][] scores;
		int noOfChampions;
		for (int i = 0; i < noOfTests; i++) {
			scores = c.generateRandomScores();

			for (int f = 0; f < scores.length; f++) {
				for (int g = 0; g < scores.length; g++) {
					if (f == g) {
						Assert.assertEquals(0, scores[f][g]);
					} else {
						Assert.assertEquals(0, scores[f][g] + scores[g][f]);
					}
				}
			}

			System.out.print("Input score matrix \n" +c.printScoreMatrix(scores));
			noOfChampions = c.findChampions(scores);
			System.out.println("\nNo of champions = " + noOfChampions);
			Assert.assertTrue(noOfChampions >= 0);
			System.out.println("-------------------------\n");
		}
	}
}
