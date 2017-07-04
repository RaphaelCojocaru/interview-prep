import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static String solveIt(String s) {
        char[] arr = s.toCharArray();
        int start = 0, end = arr.length - 1;
        boolean change = false;
        int j = 0;
        
        for (int i = end; i > 0; i--) {
            for (j = i - 1; j >= 0; j--)
                if (arr[i] > arr[j]) {
                    char aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                    change = true;
                    break;
                }
            
            if (change == true)
                break;
        }
        
        if (change == false)
            return "no answer";
        
        if (arr.length - j < 3)
            return String.valueOf(arr);
        
  
        
        for (int i = j + 1; i < arr.length - 1; i++)
            for (int k = i + 1; k < arr.length; k++)
                if (arr[i] > arr[k]) {
                    char aux = arr[i];
                    arr[i] = arr[k];
                    arr[k] = aux;
                }
        
        return String.valueOf(arr);            
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int noWords = sc.nextInt();
        for (int i = 0; i < noWords; i++) {
            String s = sc.next();
            System.out.println(solveIt(s));
        }
            
    }
}