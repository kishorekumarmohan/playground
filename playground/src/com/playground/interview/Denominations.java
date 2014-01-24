package com.playground.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kmohan
 */
public class Denominations {

	public static void main(String[] args) {
		Denominations d = new Denominations();
		System.out.println(d.calculate(13, 0));
	}

	static int coins[] = { 100, 50, 25, 10, 5, 1 };
	List<Integer> result = new ArrayList<Integer>();
	int i = 0;

	public List<Integer> calculate(int amount, int coin) {
		// init
		if (coin == 0) {
			result = new ArrayList<Integer>();
			i = 0;
		}
		// we are done
		if (amount == 0) {
			return result;
		}
		coin = coins[i];
		if (amount >= coin) {
			result.add(coin);
			amount = amount - coin;
		} else {
			coin = coins[++i];
		}
		calculate(amount, coin);
		return result;
	}
}
