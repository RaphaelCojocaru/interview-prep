import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
         BigInteger factorial = BigInteger.valueOf(1);

        // for (int i = 2; i <= n; i++) {
        //     factorial = factorial.multiply(BigInteger.valueOf(i));
        // }

        // System.out.println(factorial);

        System.out.println(aux(n));
    }

    public static BigInteger aux(int n) {
        if (n == 1) {
            return BigInteger.valueOf(1);
        }

        BigInteger factorial = BigInteger.valueOf(n);

        return factorial.multiply(aux(n - 1));
    }
}

// https://www.hackerrank.com/challenges/extra-long-factorials/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
