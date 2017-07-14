import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/quicksort4
public class Solution {
    private static int quicksort_shifts = 0;
    private static int insertionsort_shifts = 0;
    
	public static void quickSort(int[] array, int low, int high) {
		int i = low, j = high - 1, temp;
		int pivot_index = array[high];
		// Get the pivot element from the middle of the list
        // int PIVOT = array[low + (high-low)/2]; 
        
		while (i <= j) {
			while (array[i] < pivot_index)
				i++;
			while (array[j] > pivot_index)
				j--;
			
			if (i <= j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
                quicksort_shifts++;
				i++;
				j--;
			}		
        }	
        
	    temp = array[i];
        array[i] = array[high];
		array[high] = temp;
        quicksort_shifts++;
        
		if (low < j)
			quickSort(array, low, j);
		if (i < high)
			quickSort(array, i, high);
	}
    
    public static void insertionSortPart2(int[] arr) {
        int i, j, currValue;
        
        for (i = 1; i < arr.length; i++) {
            currValue = arr[i];
            j = i;
            
            while (j > 0 && arr[j - 1] > currValue) {
                arr[j] = arr[j - 1];
                insertionsort_shifts++;
                j--;
            }
            
            arr[j] = currValue;
           // insertionsort_shifts++;
        }
        
    }  
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = sc.nextInt();
            array2[i] = array1[i];
        }
        quickSort(array1, 0, n - 1);
        insertionSortPart2(array2);
        System.out.println(insertionsort_shifts - quicksort_shifts);
    }
}