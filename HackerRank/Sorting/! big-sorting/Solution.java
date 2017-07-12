import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static class LexicographicComparator implements Comparator<String> {
	    public int compareLexicographically(String s1, String s2) {
	        
	        for (int i = 0; i < s1.length(); i++) {
	            if (s1.charAt(i) < s2.charAt(i))
	                return -1;
	            else if (s1.charAt(i) > s2.charAt(i))
	                return 1;
	            else 
	                continue;
	        }
	        
	        return 0;
	    }
	    
	    @Override
	    public int compare(String s1, String s2) {
            if (s1.length() > s2.length())
                return 1;
            else if (s1.length() < s2.length())
            	return -1;
            else
            	return compareLexicographically(s1, s2);
	    }
	}
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
        Arrays.sort(unsorted, new Solution.LexicographicComparator());
		for (String s : unsorted)
			System.out.println(s);
    }
}
