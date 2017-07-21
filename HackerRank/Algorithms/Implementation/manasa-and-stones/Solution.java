import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/manasa-and-stones
public class Solution {
    public static void findLastStone(int stonesNumber, int distance1, int distance2) {
        // fint the lower and bigger distance
        int lowerDistance = Math.min(distance1, distance2); // DOESN'T need a cast (int) Math.min()
        int biggerDistance = Math.max(distance1, distance2);
        
        // compute the smallest possible value for last stone as:
        // (stonesNumber - 1) * lowerDistance
        int lastStone = (stonesNumber - 1) * lowerDistance;
        System.out.print(lastStone + " ");
        
        // if we have only one distance then return
        if (lowerDistance == biggerDistance)
            return;
        
        // compute the next possible value by adding the difference
        for (int i = 1; i < stonesNumber; i++) {
            lastStone += (biggerDistance - lowerDistance);
            System.out.print(lastStone  + " " );
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int testsNumber, stonesNumber, distance1, distance2;
        Scanner sc = new Scanner(System.in);
        
        testsNumber = sc.nextInt();
        for (int test = 0; test < testsNumber; test++) {
            stonesNumber = sc.nextInt();
            distance1 = sc.nextInt();
            distance2 = sc.nextInt();
            findLastStone(stonesNumber, distance1, distance2);
            System.out.println();
        }
    }
}