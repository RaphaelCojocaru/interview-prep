import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/strange-advertising
public class Solution {

    public static int countPeople(int n) {
        int total = 0, people = 5;
        
        for (int i = 0; i < n; i++) {
            people /= 2;
            total += people;
            people *= 3;   
        }
        
        return total;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int daysNumber = sc.nextInt();
        System.out.println(countPeople(daysNumber));
    }
}