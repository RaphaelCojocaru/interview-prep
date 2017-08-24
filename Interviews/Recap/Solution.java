/*
input : two strings A and B
output : a string containing all the characters that appear in both strings and the order should be accordingly with the order from the A string

Obs: uppercase & lowercase

1. building the hashset using the B string: m elements -> O(m)
2. O(n) 

Time complexity : O(Max(n, m))
*/
package Recap;

import java.util.*;

public class Solution {
	public static String inBothStrings(String A, String B) {
		StringBuilder sb = new StringBuilder();

		if (A == null || B == null)
			return null;

		for (char chA : A.toCharArray()) {
			for (char chB : B.toCharArray())
				if (chA == chB) {
					sb.append(chA);
					break;
				}
		}

		return sb.toString();
	}

	public static String inBothStrings2(String A, String B) {
		StringBuilder sb = new StringBuilder();
		HashSet<Character> hs = new HashSet<Character>();

		if (A == null || B == null)
			return null;

		for (char ch : B.toCharArray())
			hs.add(ch);

		for (char ch : A.toCharArray())
			if (hs.contains(ch))
				sb.append(ch);

		return sb.toString();
	}

	public static void main(String[] args) {
		String A = "interview";
		String B = "vintage";

		String result = inBothStrings(A, B);
		System.out.println(result);
		String result2 = inBothStrings2(A, B);
		System.out.println(result);
		
		char ch = 'a';
		System.out.println(Character.isLetter(ch));
		System.out.println(Character.isDigit(ch));
	}
}