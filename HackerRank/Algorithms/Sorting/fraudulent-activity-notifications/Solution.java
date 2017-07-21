import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/fraudulent-activity-notifications
public class Solution {

    public static void quickSort(int[] array, int low, int high) {
        int i = low, j = high, pivot = array[low + (high - low) / 2], temp;
        
        while (i <= j) {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
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
    
    public static void insertionSort(int[] array, int index) {
        int j = index;
        int value = array[index];
        while (j > 0 && array[j - 1] > index) {
            array[j] = array[j - 1];
            j--;
        }
        array[j] = value;
    }
    
    public static int countFraudulentActivities(int n, int[] arr, int d) {
        int count = 0, median;
        int low = 0;
        int high = d - 1;
        
		// perform an initial sorting
        quickSort(arr, low, high); 
        
        for (int i = d; i < n; i++) { // current day
            // find the median
            if (d % 2 == 0) 
                median = arr[low + (high - low) / 2] + arr[low + (high - low) / 2 + 1];
            else 
                median = arr[low + (high - low) / 2];
            //System.out.println(median + " : " + arr[i]);
            if (arr[i] >= 2 * median)
                count++;
            // insert the current item keeping the nondecreasing order
            insertionSort(arr, i);
            low++;
            high++;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n, d;
        int[] arr;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        d = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(countFraudulentActivities(n, arr, d));
    }
}