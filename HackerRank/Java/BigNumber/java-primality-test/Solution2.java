import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/java-primality-test/problem
public class Solution2 {
    public static String isProbablyPrime(String largeValue) {
        BigInteger value = new BigInteger(largeValue);

        if (value.isProbablePrime(100)) {
            return "prime";
        }

        return "not prime";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();

        System.out.println(isProbablyPrime(n));

        bufferedReader.close();
    }
}
