import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/insertionsort1
public class Solution {
    
    
    public static void insertionSort(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int index = ar[i];
            int j = i;
            while (j > 0 && ar[j - 1] > index) {
                ar[j] = ar[j - 1];
                j--;
            }
            ar[j] = index;
        }
    }
    
    public static void insertIntoSorted(int[] arr) {
        // Fill up this function  2 4 6 8 3
        int value = arr[arr.length - 1];
        int i = arr.length - 1;
        
        while (i > 0 && arr[i - 1] > value) {
            arr[i] = arr[i - 1];
            i--;
            printArray(arr);
        }

        arr[i] = value;
        printArray(arr);
    }
    
    
    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++){
            ar[i] = in.nextInt(); 
        }
        
        insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
        for(int n : ar)
            System.out.print(n + " ");
        
        System.out.println();
    }
}
 
