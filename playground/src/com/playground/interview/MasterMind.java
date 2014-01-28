package com.playground.interview;

import java.util.Random;
import java.util.Scanner;

/**
 * @author kmohan
 * Implemented by not using any Java collections api.
 */
public class MasterMind {

	final char COLORS[] = { 'R', 'B', 'G', 'Y' };

	final int MAX = 3;
	final int MIN = 0;

	public static void main(String s[]) {
		MasterMind mm = new MasterMind();
		final char code[] = mm.codeMaker();
		System.out.print("Enter your choice here (e.g.: RBGY) : ");

		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		while (true) {
			char[] input = scanner.nextLine().toUpperCase().toCharArray();
			if (input.length != 4) {
				System.out.println("Invalid input, try again");
				continue;
			}
			int[] results = mm.codeBreaker(input, code);

			System.out.println("hits : " + results[0] + "; pseudo-hits : " + results[1]);
			counter++;

			if (results[0] == 4) {
				System.out.println("Wow! you won a jackpot, Computer generated code is " + new String(code));
				break;
			}
			if (counter == 8) {
				System.out.println("Sorry you lost. Try again. Computer generated code is : " + new String(code));
				break;
			}
			System.out.print("Enter your choice here (e.g.: RBGY) : ");
		}
		scanner.close();
	}

	/**
	 * Generates 4 char random code (e.g.: RGYR, RBYG etc)
	 * 
	 * @return char[]
	 */
	public char[] codeMaker() {
		char code[] = new char[4];
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int n = MAX - MIN + 1;
			int j = random.nextInt() % n;
			int randomNum = Math.abs(MIN + j);
			code[i] = COLORS[randomNum];
		}
		return code;
	}

	/**
	 * Validates the user input code against the computer generated code and
	 * returns the no of hits and psuedo-hits
	 * 
	 * @param char[] input
	 * @param final char[] code
	 * @return
	 */
	public int[] codeBreaker(char[] input, final char[] code) {
		int[] results = new int[2];
		char[] reset = new char[4];
		int k = 0;
		for (int i = 0; i < code.length; i++) {
			if (code[i] == input[i]) {
				results[0]++;
				reset[k++] = input[i];
				input[i] = 'X';
			}
		}
		for (int m = 0; m < reset.length; m++) {
			for (int j = 0; j < input.length; j++) {
				if (input[j] == reset[m]) {
					input[j] = 'X';
				}
			}
		}

		char[] c1 = new char[4];
		for (int i = 0; i < code.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (code[i] == input[j] && !hasAlreadyAccounted(c1, code[i])) {
					results[1]++;
					c1[i] = code[i];
				}
			}
		}
		return results;
	}

	private boolean hasAlreadyAccounted(char[] c, char i) {
		boolean found = false;
		for (int n = 0; n < c.length; n++) {
			if (c[n] == i) {
				return true;
			}
		}
		return found;
	}
}
