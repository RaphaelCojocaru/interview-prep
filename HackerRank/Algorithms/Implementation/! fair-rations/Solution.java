import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/fair-rations/problem
public class Solution {
    
    public static void countMinLoaves(int[] array) {
        int count = 0;
        
        if (array.length == 0)
            System.out.println(0);
        
        for(int i = 0; i < array.length - 1; i++) 
            if (array[i] % 2 != 0) {
                array[i]++;
                array[i + 1]++;
                count += 2;
            }
        
        if (array[array.length - 1] % 2 == 0)
            System.out.println(count);
        else
            System.out.println("NO");
        
    }
    
    // 2 4 2 3
    // count = 0 -> 2 -> 4 -> 6
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        
        boolean allEven = true;
        for(int B_i=0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
            if (B[B_i] % 2 != 0)
                allEven = false;
        }
        
        if (allEven == true)
            System.out.println(0);
        else
            countMinLoaves(B);
        
    }
}
