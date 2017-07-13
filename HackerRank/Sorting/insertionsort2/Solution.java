import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/insertionsort2
public class Solution {

    public static void insertionSortPart2(int[] arr) {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        int i, j, currValue;
        
        for (i = 1; i < arr.length; i++) {
            currValue = arr[i];
            j = i;
            
            while (j > 0 && arr[j - 1] > currValue) {
                arr[j] = arr[j - 1];
                j--;
            }
            
            arr[j] = currValue;
            printArray(arr);
        }
        
    }  
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i = 0; i < s; i++){
            ar[i] = in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }   
    
    private static void printArray(int[] ar) {
        for (int n : ar)
            System.out.print(n + " ");
      
        System.out.println();
   }
}
