import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-string-compare/problem
public class Solution2 {

    public static String getSmallestAndLargest(String s, int k) {
        if (k > s.length()) {
            return null;
        }

        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        String substring;

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        for (int i = 1; i <= s.length() - k; i++) {
            if (smallest.compareTo(s.substring(i, i + k)) > 0) {
                smallest = s.substring(i, i + k);
            }

            if (largest.compareTo(s.substring(i, i + k)) < 0) {
                largest = s.substring(i, i + k);
            }
        }

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}