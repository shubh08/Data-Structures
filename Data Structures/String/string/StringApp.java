package com.shubh.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringApp {

	public static void main(String[] args) {

		String str = "ab0213";

		System.out.println(checkIfStringUnique(str));

		System.out.println(URLify("Hello Shubham  Kumar    "));

		System.out.println(isPermutationPalindrome("abcba"));
	}

	private static boolean checkIfStringUnique(String str) {

		int stringChecker[] = new int[255];

		for (int i = 0; i < str.length(); i++) {
			System.out.println("Character Value" + Integer.valueOf(str.charAt(i)));
			if (stringChecker[str.charAt(i)] == 0) {
				stringChecker[str.charAt(i)] = 1;
			}

			else {
				stringChecker[str.charAt(i)] = stringChecker[str.charAt(i)] + 1;
			}
		}

		for (int i = 0; i < str.length(); i++) {
			if (stringChecker[str.charAt(i)] > 1) {
				return true;
			}

		}

		return false;

	}

	public static String URLify(String s1) {

		StringBuilder finalString = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {

			if (s1.charAt(i) == ' ') {
				count = 1;
			}

			else {
				if (count == 1) {
					finalString.append("%20");
				}
				finalString.append(s1.charAt(i));
				count = 0;

			}
		}
		return finalString.toString();
	}

	public static boolean isPermutationPalindrome(String str) {

		Map<Character, Integer> map = new HashMap<>();

		for (char c : str.toCharArray()) {
			if (!map.containsKey(c))
				map.put(c, 1);

			else {
				map.put(c, (map.get(c)) + 1);
			}
		}

		int oddCount = 0;

		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				oddCount++;
				if (oddCount > 1)
					return false;
			}

		}

		return true;

	}

	public static boolean checkIfPermutationStrings(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;
		int charArray[] = new int[255];
		for (int i = 0; i < s1.length(); i++) {
			if (charArray[s1.charAt(i)] == 0) {
				charArray[s1.charAt(i)] = 1;
			}

			else
				charArray[s1.charAt(i)]++;

		}
		for (int i = 0; i < s2.length(); i++) {
			if (charArray[s2.charAt(i)] > 0) {
				charArray[s2.charAt(i)]--;

				if (charArray[s2.charAt(i)] < 0) {
					return false;
				}
			}

			else
				return false;

		}
		return true;
	}

}
