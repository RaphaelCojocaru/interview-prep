import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/kaprekar-numbers/problem
public class Solution {

    // return the number of digits of the number
    public static int numberLength(long n) {
        int count = 0;
        
        while (n > 0) {
            n = n / 10;
            count++;
        }
        
        return count;
    }
    
    public static void kaprekarNumbers(int start, int end) {
        String output = "";
        for (int value = start; value <= end; value++) {
            if (value == 1)
                output += value + " ";
            // use long for computing the square
            long copy = (long) value * value;
            int length = numberLength(copy );
            int length1 = length / 2;
            int length2 = length - length1;
            // compute the first and second halves of the number
            long firstHalf = copy / (long) Math.pow(10, length2);
            long secondHalf = copy % (long) Math.pow(10, length2);
            // no half should be equal to 0
            if (firstHalf == 0 || secondHalf == 0)
                continue;
 
            if (length1 == 0)
                firstHalf = 0;
            if (length2 == 0)
                secondHalf = 0;

            if (firstHalf + secondHalf == value)
                output += (value + " ");
        }
        
        if (output.length() == 0)
            System.out.println("INVALID RANGE");
        else
            System.out.println(output.substring(0, output.length() - 1));
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        kaprekarNumbers(start, end);
    }
}