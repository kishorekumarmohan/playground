package com.playground.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author kmohan
 */
public class DollarAmountInWords {

	private StringBuffer m_amountInWords;

	static Map<String, String> s_ones = new HashMap<String, String>();
	static Map<String, String> s_tens = new HashMap<String, String>();
	static Map<String, String> s_elevenToNineteen = new HashMap<String, String>();

	static final String HUNDRED = " hundred ";

	static String s_nameOfLargeNumbers[] = { "dollars", "thousand", "million", "billion", "trillion" };

	static {
		s_ones.put("1", "one");
		s_ones.put("2", "two");
		s_ones.put("3", "three");
		s_ones.put("4", "four");
		s_ones.put("5", "five");
		s_ones.put("6", "six");
		s_ones.put("7", "seven");
		s_ones.put("8", "eight");
		s_ones.put("9", "nine");
		s_ones.put("0", "");

		s_tens.put("1", "ten");
		s_tens.put("2", "twenty");
		s_tens.put("3", "thirty");
		s_tens.put("4", "forty");
		s_tens.put("5", "fifty");
		s_tens.put("6", "sixty");
		s_tens.put("7", "seventy");
		s_tens.put("8", "eighty");
		s_tens.put("9", "ninety");
		s_tens.put("0", "");

		s_elevenToNineteen.put("11", "eleven");
		s_elevenToNineteen.put("12", "twelve");
		s_elevenToNineteen.put("13", "thirteen");
		s_elevenToNineteen.put("14", "fourteen");
		s_elevenToNineteen.put("15", "fifteen");
		s_elevenToNineteen.put("16", "sixteen");
		s_elevenToNineteen.put("17", "seventeen");
		s_elevenToNineteen.put("18", "eignteen");
		s_elevenToNineteen.put("19", "nineteen");
	}

	public static void main(String[] args) {
		String inputStr = null;
		try {
			inputStr = args[0];
		} catch(Exception e) {
			inputStr = "8724657234.78";
		}
		
		DollarAmountInWords dollarAmountInWords = new DollarAmountInWords();
		System.out.println(dollarAmountInWords.amountToWords(inputStr));
	}

	public String amountToWords(String inputStr) {
		m_amountInWords = new StringBuffer();
		inputStr = inputStr.replace(",", "").trim();
		if (inputStr.indexOf(".") < 0) {
			inputStr = inputStr + ".00";
		}

		// extract cents
		String cents = inputStr.substring(inputStr.indexOf(".") + 1, inputStr.length());

		// extract dollars
		inputStr = inputStr.substring(0, inputStr.indexOf("."));

		int inputStrLength = inputStr.length() / 3;

		List<String> dollars = new ArrayList<String>();

		for (int i = 0; i < inputStrLength; i++) {
			dollars.add(inputStr.substring(inputStr.length() - 3, inputStr.length()));
			inputStr = inputStr.substring(0, inputStr.length() - 3);
		}
		if (inputStr.length() != 0) {
			dollars.add(inputStr);
		}

		int dollarsListSize = dollars.size();

		if (dollarsListSize == 0) {
			dollarsListSize = 1;
		}

		for (int i = dollarsListSize - 1; i >= 0; i--) {
			convert(dollars.get(i));
			if (i != 0) {
				m_amountInWords.append(" ");
				m_amountInWords.append(s_nameOfLargeNumbers[i]);
				m_amountInWords.append(", ");
			}
		}

		convertCents(cents);
		return m_amountInWords.toString().replace("  ", " ");
	}

	private void convert(String s) {
		int i = Integer.parseInt(s);
		s = String.valueOf(i);
		if (s.length() == 3) {
			convertHundreds(s);
		} else if (s.length() == 2) {
			convertTens(s);
		} else if (s.length() == 1) {
			convertOnes(s);
		}
	}

	private void convertHundreds(String s) {
		m_amountInWords.append(s_ones.get(s.charAt(0) + ""));
		m_amountInWords.append(HUNDRED);
		m_amountInWords.append(s_tens.get(s.charAt(1) + ""));
		if (s.charAt(1) != '0' && s.charAt(2) != '0') {
			m_amountInWords.append("-");
		}
		m_amountInWords.append(s_ones.get(s.charAt(2) + ""));
	}

	private void convertTens(String s) {
		int i = Integer.parseInt(s);
		if (i >= 11 && i <= 19) {
			m_amountInWords.append(s_elevenToNineteen.get(s));
		} else {
			m_amountInWords.append(s_tens.get(s.charAt(0) + ""));
			m_amountInWords.append(" ");
			m_amountInWords.append(s_ones.get(s.charAt(1) + ""));
		}
	}

	private void convertOnes(String s) {
		m_amountInWords.append(s_ones.get(s));
	}

	private void convertCents(String s) {
		int i = Integer.parseInt(s);
		if (i == 0) {
			s = "00";
		}
		m_amountInWords.append(" and ");
		m_amountInWords.append(s);
		m_amountInWords.append("/100 dollars");
	}
}
