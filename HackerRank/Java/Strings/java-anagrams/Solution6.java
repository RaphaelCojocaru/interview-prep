import java.util.Scanner;

public class Solution6 {
    // https://www.hackerrank.com/challenges/java-anagrams/problem
    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }

        HashMap<Character, Integer> occurrencesFirstString = new HashMap<>();
        HashMap<Character, Integer> occurrencesSecondString = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            if (occurrencesFirstString.containsKey(a.charAt(i))) {
                occurrencesFirstString.put(a.charAt(i), occurrencesFirstString.get(a.charAt(i)) + 1);
            } else {
                occurrencesFirstString.put(a.charAt(i), 0);
            }

            if (occurrencesSecondString.containsKey(b.charAt(i))) {
            	occurrencesSecondString.put(b.charAt(i), occurrencesSecondString.get(b.charAt(i)) + 1);
            } else {
            	occurrencesSecondString.put(b.charAt(i), 0);
            }
        }

        for (Map.Entry<Character, Integer> entry : occurrencesFirstString.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();
            if (!occurrencesSecondString.containsKey(key) || occurrencesSecondString.get(key) != count) {
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
