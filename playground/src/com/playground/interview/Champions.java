package com.playground.interview;

import java.util.Random;

/**
 * @author kmohan
 */
public class Champions {

	public int findChampions(int[][] scores) {
		int[] champions = new int[scores.length];
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				int score = scores[i][j];
				if (score == -1) {
					champions[i] = -1;
				}
			}
		}

		int countChampions = 0;
		for (Integer k : champions) {
			if (k > -1) {
				countChampions++;
			}
		}
		if (countChampions == 0) {
			// all of them are champions
			countChampions = champions.length;
		}
		return countChampions;
	}

	public int[][] generateRandomScores() {
		int[] possibleScores = { -1, 0, 1 };
		int val;
		int maxNoOfPlayers = 10;
		int minNoOfPlayers = 3;

		Random r = new Random();
		int size = r.nextInt(maxNoOfPlayers);
		while (size < minNoOfPlayers) {
			size = r.nextInt(maxNoOfPlayers);
			if (size >= minNoOfPlayers) {
				break;
			}
		}
		int[][] scores = new int[size][size];
		for (int j = 0; j < size; j++) {
			for (int k = j; k < size; k++) {
				if (j == k) {
					val = 1; // which is possibleScores[1] value 0.
				} else {
					val = r.nextInt(possibleScores.length);
				}
				scores[j][k] = possibleScores[val];
				scores[k][j] = possibleScores[val] * -1;
			}
		}
		return scores;
	}

	public String printScoreMatrix(int[][] scores) {
		StringBuffer sb = new StringBuffer();
		for (int f = 0; f < scores.length; f++) {
			for (int g = 0; g < scores[f].length; g++) {
				sb.append(scores[f][g]);
				if (g < (scores[f].length - 1)) {
					sb.append(", ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
