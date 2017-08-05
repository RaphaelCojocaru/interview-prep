package Arrays_Strings;

import java.util.Scanner;

// Given two strings, s1 and s2, write code to check If s2 is a rotation of s1
//using only one call to isSubstring
public class Solution {
	public static String isRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return "NO";
		s1 = s1 + s1;
		if (s1.contains(s2) == true)
			return "YES";

		return "NO";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			String[] parts = line.split("\\s+");
			System.out.println(isRotation(parts[0], parts[1]));
		}
		sc.close();
	}
}
