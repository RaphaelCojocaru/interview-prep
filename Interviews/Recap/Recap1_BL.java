package Recap;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;

public class Recap1_BL {
	public enum Order {
		INCREASING, DECREASING
	}

	// order specifies how the sorting is done: increasing or decreasing order
	public static void quickSort(int[] arr, int low, int high, Order order) {
		int i = low, j = high, pivot = arr[low + (high - low) / 2], temp;

		while (i <= j) {
			if (order == Order.INCREASING) {
				while (arr[i] < pivot)
					i++;
				while (arr[j] > pivot)
					j--;
			} else if (order == Order.DECREASING) {
				while (arr[i] > pivot)
					i++;
				while (arr[j] < pivot)
					j--;
			}

			if (i <= j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(arr, low, j, order);
		if (i < high)
			quickSort(arr, i, high, order);
	}

	public static void printArray(int[] arr) {
		for (int value : arr)
			System.out.print(value + " ");
		System.out.println();
	}

	public static int binarySearch(int[] array, int value) {
		int low = 0, high = array.length - 1;
		int middle;

		while (low <= high) {
			middle = low + (high - low) / 2;

			if (array[middle] == value)
				return middle;
			else if (value < array[middle])
				high = middle - 1;
			else if (value > array[middle])
				low = middle + 1;
		}

		return -1;
	}

	public static int binarySearch2(int[] arr, int value) {
		int low = 0, high = arr.length - 1, middle;

		while (low <= high) {
			middle = low + (high - low) / 2;
			if (value == arr[middle])
				return middle;
			if (value < arr[middle])
				high = middle - 1;
			else
				low = middle + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		// Hash Set
		HashSet<Integer> hs = new HashSet<>();
		hs.add(1);
		hs.remove(1);
		hs.contains(1);
		hs.size();
		hs.iterator();

		// Hash Map
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(1, 1);
		hm.containsKey(1);
		hm.containsValue(1);
		int key = 2;
		hm.remove(key);
		hm.size();
		hm.get(key);
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			entry.getKey();
			entry.getValue();
		}

		// Priority Queue
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		pq.add(2);
		pq.add(4);
		System.out.println(pq.poll());

		Random gen = new Random();
		int[] arr = new int[30];
		for (int i = 0; i < 30; i++)
			arr[i] = gen.nextInt(100);

		quickSort(arr, 0, arr.length - 1, Order.DECREASING);
		printArray(arr);
		quickSort(arr, 0, arr.length - 1, Order.INCREASING);
		printArray(arr);

		Stack<Integer> s = new Stack<>();
		// s.peek();

		int[] arr2 = new int[20];
		for (int i = 0; i < 20; i++)
			arr2[i] = i * 2;

		printArray(arr2);
		System.out.println(binarySearch(arr2, 34));
		System.out.println(binarySearch(arr2, 34));


	}
}
