package Arrays_Strings;

import java.util.*;

public class Solution {

	// Consider string to be composed of ascii characters
	public static boolean uniqueCharacters(String s) {
	    	//  256 ASCII characters : standard (0-127) and Extended ASCII characters(128-255)
		int[] occurrences = new int[256];
	    
		if (s.length() > 256)
			return false;
	                  
		for (int i = 0; i < s.length(); i++) {
			if (occurrences[s.charAt(i) - 'a'] != 0)
				return false;
			else
				occurrences[s.charAt(i) - 'a']++;
		}  
	        
		return true;
	        
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String str;
		for (int i = 0; i < n; i++) {
			str = sc.nextLine();
			System.out.println(uniqueCharacters(str));
		}
		
		sc.close();
	}
}
