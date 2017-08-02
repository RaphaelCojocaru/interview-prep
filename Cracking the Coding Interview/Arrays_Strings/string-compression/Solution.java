package Arrays_Strings;

import java.util.Scanner;

// Implement a method to perform basic string compression using the counts of
//repeated characters. For example, the string aabcccccaaa would become
//a2blc5a3.
public class Solution {

	public static String compress(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			// get the current char
			char currChar = str.charAt(i);
			// count the number of identical consecutive characters
			int count = 1;
			// start from i + 1
			i++;
			while (i < str.length() && str.charAt(i) == currChar) {
				count++;
				i++;
			}
			// Attention to get a position backwards
			i--;

			if (count > 1) {
				sb.append(currChar);
				sb.append(count);
			} else
				sb.append(currChar);
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String compressed = compress(str);
		System.out.println(compressed);
		sc.close();
	}
}
