import java.util.*;
import java.io.*;

// https://www.hackerrank.com/challenges/java-loops
class Solution{
    public static void printSeries(int a, int b, int n) {
        int total = 0;
        
        total = a + b;
        System.out.print(total + " ");    
        
        for (int i = 1; i < n; i++) {
            total += Math.pow(2, i) * b;
                
            System.out.print(total + " ");   
        }
        System.out.println();
    }
    
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            printSeries(a, b, n);
        }
        in.close();
    }
}

