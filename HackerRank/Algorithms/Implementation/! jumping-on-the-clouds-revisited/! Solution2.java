import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
public class Solution2 {

    static int jumpingOnClouds(int[] c, int dist) {
        int n = c.length;

        int start = 0, energyLevel = 100;

        start = (start + dist) % n;
        energyLevel--;
        if (c[start] == 1) {
            energyLevel -=2;
        }

        while (start != 0) {
            start = (start + dist) % n;

            energyLevel -= 1;

            if (c[start] == 1) {
                energyLevel -= 2;
            }
        }

        return energyLevel;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
