package Arrays_Strings;

import java.util.*;

// Given two strings, write a method to decide if one is a permutation of the other
public class Solution {

	public static boolean isPermutation(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;

		HashMap<Character, Integer> occurrences = new HashMap<Character, Integer>();

		for (char ch : s1.toCharArray())
			if (occurrences.containsKey(ch) == true)
				occurrences.put(ch, occurrences.get(ch) + 1);
			else
				occurrences.put(ch, 1);

		for (char ch : s2.toCharArray())
			if (occurrences.containsKey(ch) == true)
				occurrences.put(ch, occurrences.get(ch) - 1);
			else
				return false;


		for (Map.Entry<Character, Integer> entry : occurrences.entrySet())
			if (entry.getValue() != 0)
				return false;
		
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] strings;
		String line;
		for (int i = 0; i < n; i++) {
			line = sc.nextLine();
			strings = line.split(" ");
			System.out.println(isPermutation(strings[0], strings[1]));
		}

		sc.close();
	}
}
