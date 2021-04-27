import java.util.*;
import java.io.*;
import java.math.BigInteger;

// https://www.hackerrank.com/challenges/java-datatypes/problem
class Solution2 {
    public static void determineDataType(long value) {
        System.out.println(value + " can be fitted in:");

        if (value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE) {
            System.out.println("* byte");
        }
        if (value >= Short.MIN_VALUE && value <= Short.MAX_VALUE) {
            System.out.println("* short");
        }
        if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
            System.out.println("* int");
        }
        if (value >= Long.MIN_VALUE && value <= Long.MAX_VALUE) {
            System.out.println("* long");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfQueries = Integer.parseInt(scan.nextLine());
        BigInteger value;

        for (int i = 0; i < noOfQueries; i++) {
            value = new BigInteger(scan.nextLine());

            if (value.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0 || value.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
                System.out.println(value + " can't be fitted anywhere.");
                continue;
            }

            determineDataType(value.longValue());
        }
    }
}
