import java.util.Scanner;

public class Solution5 {
    // https://www.hackerrank.com/challenges/java-anagrams/problem
    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
        
        int[] occurrences = new int[26];

        for (int i = 0; i < a.length(); i++) {
            occurrences[Character.toLowerCase(a.charAt(i)) - 'a']++;
            occurrences[Character.toLowerCase(b.charAt(i)) - 'a']--;
        }

        for (int occurrence : occurrences) {
            if (occurrence != 0) {
                return false;
            }
        }
        
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
