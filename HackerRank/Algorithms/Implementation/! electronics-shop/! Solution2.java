import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/electronics-shop/problem
public class Solution2 {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int budget) {
        int max = -1;
        Integer[] key = new Integer[keyboards.length];
        for (int i = 0; i < keyboards.length; i++) {
            key[i] = Integer.valueOf(keyboards[i]);
        }

        Arrays.sort(key, Collections.reverseOrder());
        Arrays.sort(drives);
        
        for (int i = 0, j = 0; i < key.length; i++) {
            for (; j < drives.length; j++) {
                if (key[i] + drives[j] > budget) break;
                if (key[i] + drives[j] > max)
                    max = key[i] + drives[j];
            }
        }
        
        return max;
    }
    
    static int computeMaxMoneySpentRecursive(int[] keyboards, int i, int[] drives, int j, int budget) {
        if (i >= keyboards.length || j >= drives.length) {
            return -1;
        }
        
        if (keyboards[i] + drives[j] > budget) {
            return -1;
        }
      
      int maxBetterKeyboard = Math.max(keyboards[i] + drives[j], computeMaxMoneySpentRecursive(keyboards, i + 1, drives, j, budget));
      
      int maxBetterDriver = Math.max(keyboards[i] + drives[j], computeMaxMoneySpentRecursive(keyboards, i, drives, j + 1, budget));
      
      return Math.max(maxBetterKeyboard, maxBetterDriver);
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
