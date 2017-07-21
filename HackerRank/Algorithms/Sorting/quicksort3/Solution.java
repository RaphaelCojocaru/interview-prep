import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/quicksort3
public class Solution {
    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    
    public static void quickSort(int[] array, int low, int high) {
        int i, j, temp, pivot;
        
        pivot = array[high];
        i = low;
        j = high - 1;
        
        if (high - low < 2)
            return;
        
        while (i <= j) {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;
            
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        
        printArray(array);
       
        if (low < j)
            quickSort(array, low, j);
        if (i < high)
            quickSort(array, i, high);
        
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        
        quickSort(array, 0, n - 1);
    }
}