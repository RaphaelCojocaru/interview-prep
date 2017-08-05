import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
public class Solution {

    public static int jumpingClouds(int[] clouds, int n, int distance) {
        int start = 0, energy = 100;
        
        // performe first jump
        start = (start + distance) % n;
        energy--;
        if (clouds[start] == 1)
            energy -= 2;    
        
        while (start != 0) {
            start = (start + distance) % n;
            energy--;
            if (clouds[start] == 1)
                energy -= 2;
        }
        
        return energy;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        System.out.println(jumpingClouds(c, n, k));
    }
}
