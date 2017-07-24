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
			quickSort(array, low, j);
		if (i < high)
			quickSort(array, i, high);
	}
    
  /*  
    Prep stage:
create map with:
keys : values from input list,
values : indexes of values from input list,
make a copy of sorted input list
Algo stage:
Iterate through input list, and compare current value (lets call it cv) against value from sorted list (lets call it scv). If it is diffrent:
increment number of swaps
get index of the scv from map - map[scv],
in input list swap cv with scv,
update map[cv]=map[scv] (map[scv] does not need to be updated as we are not going to use it any more)
Then you need to execute it on input list and reversed input list - the smaller return value - is the answer.
    */
    
    public static int getSwapsNo(int[] arr, int[]arr_sorted, HashMap<Integer, Integer> hash) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr_sorted[i]) {
                count++;
          //      System.out.println(arr[i]  + " " + i);
                int index = hash.get(arr_sorted[i]);
                hash.put(arr[i], index);
                int temp = arr[i];
                arr[i] = arr_sorted[i];
                arr[index] = temp;
            }
        }
        // System.out.println("------");
        return count;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] array = new int[n];
        HashMap<Integer, Integer> hash = new HashMap<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            hash.put(array[i], i);
            hash2.put(array[i], i);
        }
        int[] array2 = Arrays.copyOf(array, array.length);
        int[] array_copy1 = Arrays.copyOf(array, array.length);
        int[] array_copy2 = Arrays.copyOf(array, array.length);
        quickSort(array_copy1, 0, n - 1);
        quickSortReversed(array_copy2, 0, n - 1);
        
        int swapsSorted = getSwapsNo(array, array_copy1, hash);
        int swapsSortedReversed = getSwapsNo(array2, array_copy2, hash2);
        if (swapsSorted < swapsSortedReversed)
            System.out.println(swapsSorted);
        else
            System.out.println(swapsSortedReversed);
    }
}