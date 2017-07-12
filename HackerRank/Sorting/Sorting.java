package Implementation;

import java.util.Random;

public class Sorting {
	
	public static void quickSort(int[] array, int low, int high) {
		int i = low, j = high, temp;
		int pivot_index = (low + high) / 2;
		// Get the pivot element from the middle of the list
        // int PIVOT = array[low + (high-low)/2]; 
        
		while (i <= j) {
			while (array[i] < array[pivot_index])
				i++;
			while (array[j] > array[pivot_index])
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
	
	public static void main(String[] args) {
		int[] array = new int[20];
		Random random = new Random();
		for (int i = 0; i < 20; i++)
			array[i] = random.nextInt(100); //	exclusiv 100
		
		System.out.println("======= BEFORE =======");
		for (int value : array)
			System.out.print(value + " ");
		System.out.println();
		
		// call QUICKSORT
		quickSort(array, 0, 19);
		
		System.out.println("======= AFTER =======");
		for (int value : array)
			System.out.print(value + " ");
		System.out.println();
		System.out.println(Math.random());
	}
}
