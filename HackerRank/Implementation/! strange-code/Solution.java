import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/strange-code
public class Solution {
    public static BigInteger findStrangeValue(BigInteger time) {
        BigInteger currentTime = BigInteger.valueOf(1);
        BigInteger strangeValue = BigInteger.valueOf(3);
        BigInteger old_time = currentTime;
        BigInteger old_value = strangeValue;
        
        // find the penultimate time value lower than time given as parameter
        while (currentTime.compareTo(time) <= 0) { // compareTo computes the difference
            old_time = currentTime;
            old_value = strangeValue;
            currentTime = currentTime.add(strangeValue);
            strangeValue  = strangeValue.multiply(BigInteger.valueOf(2));
        }
        
        // compute the difference between the time given as parameter
        //and the time immediately below
        BigInteger difference = time.subtract(old_time);
        
        // compute and return the value for the time
        return old_value.subtract(difference);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // SCANNER .nextBigInteger()
        BigInteger time = in.nextBigInteger();
        System.out.println(findStrangeValue(time));
    }
}
