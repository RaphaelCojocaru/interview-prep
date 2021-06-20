import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/flatland-space-stations/problem
public class Solution2 {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        int lastPumpLocation = -999999999, maxDistance = 0, nextGasIndex = 0;
        HashSet<Integer> gasPumps = new HashSet<>();

        Arrays.sort(c);

        for (int position : c) {
            gasPumps.add(position);
        }

        for (int i = 0; i < n; i++) {
            if (gasPumps.contains(i)) {
                lastPumpLocation = i;

                nextGasIndex++;

                continue;
            }

            if (nextGasIndex >= c.length) {
                lastPumpLocation = c[nextGasIndex - 1];

                break;
            }

            maxDistance = Math.max(maxDistance, Math.min(i - lastPumpLocation, c[nextGasIndex] - i));
        }

        for (int i = nextGasIndex; i < n; i++) {
            maxDistance = Math.max(maxDistance, i - lastPumpLocation);
        }

        return maxDistance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
