import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-nested-logic
public class Solution {
    
    static class MyDate {
        private int day, month, year;
        
        public MyDate() {     
        }   
    }
    
    public static int computeFine(MyDate date, MyDate expected) throws IllegalArgumentException {
        int fine = 0;
        
        if (date == null || expected == null)
            throw new IllegalArgumentException();
        
        // Before the expected date
        if (date.day <= expected.day && date.month <= expected.month && 
            date.year <= expected.year)
            return fine;
        if (date.month < expected.month && 
            date.year <= expected.year)
            return fine;
        if (date.year < expected.year)
            return fine;
        
        // Only few days over the expected date
        if (date.day > expected.day && date.month == expected.month && 
            date.year == expected.year) {
            fine = 15 * (date.day - expected.day);
            return fine;
        }
        
        // Only few months over the expected date
        if (date.month > expected.month && date.year == expected.year) {
            fine = 500 * (date.month - expected.month);
            return fine;
        }  
        
        return 10000;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        MyDate date = new MyDate();     // date of actual return
        MyDate expected = new MyDate(); // date of expected return
        
        date.day = scan.nextInt();
        date.month = scan.nextInt();
        date.year = scan.nextInt();
        
        expected.day = scan.nextInt();
        expected.month = scan.nextInt();
        expected.year = scan.nextInt();
        
        System.out.println(computeFine(date, expected));
        
        scan.close();
    }
}