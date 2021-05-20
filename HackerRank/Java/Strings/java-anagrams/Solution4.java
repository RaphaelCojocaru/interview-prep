import java.util.Scanner;

public class Solution4 {
    // https://www.hackerrank.com/challenges/java-anagrams/problem
    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
        
        int[] occurrencesFirstString = new int[26];
        int[] occurrencesSecondString = new int[26];
        
        String aInLowerCase = a.toLowerCase();
        String bInLowerCase = b.toLowerCase();

        for (char ch : aInLowerCase.toCharArray()) {
            occurrencesFirstString[ch - 'a']++;
        }

        for (Character ch : bInLowerCase.toCharArray()) {
            occurrencesSecondString[ch - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (occurrencesFirstString[i] != occurrencesSecondString[i]) {
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
