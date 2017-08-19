import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int year){
        boolean leapYear = false;
        String res;
        
        // Complete this function
        if (year < 1700 || year > 2700)
            return null;
        
        if (year == 1918) {
            return "26.09.1918";
        } else if (year > 1917) {
            if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
                leapYear = true;

            if (leapYear)
                res = "12.09.";
            else
                res = "13.09.";
        } else {
            if (year % 4 == 0)
                leapYear = true;

            if (leapYear)
                res = "12.09.";
            else
                res = "13.09.";
        }
        
        return (res + year);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
