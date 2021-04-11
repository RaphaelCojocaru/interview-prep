import java.io.*;
import java.util.*;
import java.math.BigInteger;

// https://www.hackerrank.com/challenges/java-biginteger/problem
public class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        BigInteger first = new BigInteger(scan.nextLine());
        BigInteger second = new BigInteger(scan.nextLine());

        System.out.println(first.add(second).toString());
        System.out.println(first.multiply(second));

        scan.close();
    }
}
