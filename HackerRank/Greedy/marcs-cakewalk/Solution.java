import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/marcs-cakewalk
public class Solution {
    public static void quickSort(int[] array, int low, int high) {
        int i = low, j = high, pivot = array[low + (high - low) / 2];
        int temp;
        
        while (i <= j) {
            while (array[i] > pivot)
                i++;
            while (array[j] < pivot)
                j--;
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        
        if (low < j)
            quickSort(array, low, j);
        if (i < high)
            quickSort(array, i, high);
        
    }
    
    public static void printArray(int[] array) {
        for (int value : array)
            System.out.print(value + " ");
    }
    
    public static long countMiles(int n, int[] calories) {
        long total = 0;
        
        quickSort(calories, 0, n - 1);
        
        for (int i = 0; i < n; i++) {
            total += calories[i] * Math.pow(2, i);
        }
        
        return total;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calories = new int[n];
        for(int calories_i = 0; calories_i < n; calories_i++){
            calories[calories_i] = in.nextInt();
        }
        // your code goes here
        System.out.println(countMiles(n , calories));
    }
}
