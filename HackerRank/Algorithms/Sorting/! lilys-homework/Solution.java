import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
	public static void quickSort(int[] array, int low, int high) {
		int i = low, j = high, temp;
		int pivot = array[low + (high - low) / 2]; 
        
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
    
    public static void quickSortReversed(int[] array, int low, int high) {
		int i = low, j = high, temp;
		int pivot = array[low + (high - low) / 2]; 
        
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
			quickSortReversed(array, low, j);
		if (i < high)
			quickSortReversed(array, i, high);
	}
    
    public static int getSwapsNo(int[] arr, int[] arr_sorted, HashMap<Integer, Integer> hash) {
        int count = 0;

        // count the swaps number
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr_sorted[i]) {
                count++;
                // change the value - index within the hashmap
                int index = hash.get(arr_sorted[i]);
                hash.put(arr_sorted[i], i);
                hash.put(arr[i], index);
                // change the values
                int temp = arr[i];
                arr[i] = arr_sorted[i];
                arr[index] = temp;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] array = new int[n];
        
        // store each value - index pair into the hashmaps
        HashMap<Integer, Integer> hash = new HashMap<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            hash.put(array[i], i);
            hash2.put(array[i], i);
        }
        
        // create a copy of the original array
        int[] array2 = Arrays.copyOf(array, array.length);
        
        // create two other arrays sorted in increasing/decreasing order
        int[] array_copy1 = Arrays.copyOf(array, array.length);
        int[] array_copy2 = Arrays.copyOf(array, array.length);
        quickSort(array_copy1, 0, n - 1);
        quickSortReversed(array_copy2, 0, n - 1);
        
        // compute the swaps number for both sorted arrays and return the
        // minimum value
        int swapsSorted = getSwapsNo(array, array_copy1, hash);
        int swapsSortedReversed = getSwapsNo(array2, array_copy2, hash2);
        if (swapsSorted < swapsSortedReversed)
            System.out.println(swapsSorted);
        else
            System.out.println(swapsSortedReversed);

    }
}