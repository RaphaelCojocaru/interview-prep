package Arrays_Strings;

import java.util.*;

public class Solution {

	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		int start = 0, end = s.length() - 1;
		
		if (s.length() == 1)
			return sb.toString();
	              
		while (start < end) {
			char tmp = sb.charAt(start);
			sb.setCharAt(start, sb.charAt(end));
			sb.setCharAt(end, tmp);
			start++;
			end--;
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String str;
		for (int i = 0; i < n; i++) {
			str = sc.nextLine();
			System.out.println(reverse(str));
		}
		
		sc.close();
	}
}
