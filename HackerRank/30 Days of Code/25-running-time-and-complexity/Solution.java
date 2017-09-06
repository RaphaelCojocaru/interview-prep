import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-running-time-and-complexity
public class Solution {

    public static String isPrime(int number) {
        if (number == 2)
            return "Prime";
        
        if (number % 2 == 0 || number < 2)
            return "Not prime";
        

        
        for (int i = 3; i <= (int) Math.sqrt(number); i+= 2)    
            if (number % i == 0)
                return "Not prime";
        
        return "Prime";
    }
    
    public static void main(String[] args) {
        /* Enter your code here. */
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int number = scan.nextInt();
            System.out.println(isPrime(number));
        }
        scan.close();
    }
}
