import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
public class Solution2 {

    // Complete the catAndMouse function below.
    static String catAndMouse(int a, int b, int c) {
        int distanceFromAtoC = Math.abs(a - c);
        int distanceFromBtoC = Math.abs(b - c);

        if (distanceFromAtoC < distanceFromBtoC) {
            return "Cat A";
        } else if (distanceFromBtoC < distanceFromAtoC) {
            return "Cat B";
        }

        return "Mouse C";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
