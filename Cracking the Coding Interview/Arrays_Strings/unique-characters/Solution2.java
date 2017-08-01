package Arrays_Strings;

import java.util.*;

public class Solution2 {

	// Consider string to be composed of lower-case english letters
	public static boolean uniqueCharacters(String s) {
		// use an integer's bits
		int checker = 0, index;
	    
		if (s.length() > 26)
			return false;
	                  
		for (int i = 0; i < s.length(); i++) {
			index = s.charAt(i) - 'a';
	        	if ((checker & (1 << index)) != 0)
				return false;
			else
				checker |= (1 << index);
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
