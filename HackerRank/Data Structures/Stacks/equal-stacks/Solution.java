import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/equal-stacks
public class Solution {
    
    public static int equalStacksHeight(int[] h1, int[] h2, int[] h3) {
        // create the stacks
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
        
        // compute the initial heights
        int height1 = 0, height2 = 0, height3 = 0;
        
        // push the elements in the stacks
        for (int i = h1.length - 1; i >= 0; i--) {
            s1.push(h1[i]);
            height1 += h1[i];
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            s2.push(h2[i]);
            height2 += h2[i];
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            s3.push(h3[i]);
            height3 += h3[i];
        }
        
        // while heights are not equal
        while (height1 != height2 || height1 != height3) {
            // pop an element from each stack having height bigger
            //than the overall minimum
            if (height1 > height2 || height1 > height3) {
                int height = s1.pop();
                height1 -= height;
            }
            if (height2 > height1 || height2 > height3) {
                int height = s2.pop();
                height2 -= height;
            }     
            if (height3 > height1 || height3 > height2) {
                int height = s3.pop();
                height3 -= height;
            }
        }
        
        return height1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        for(int h1_i = 0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for(int h2_i = 0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for(int h3_i = 0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }
        
        System.out.println(equalStacksHeight(h1, h2, h3));
    }
}
