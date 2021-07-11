package Big_O;

import java.util.Random;

public class Math {
	public static boolean isPrime(int value) {
		for (int x = 2; x * x <= value; x++) {
			if (value % x == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int factorial(int value) {
		if (value <= 1) {
			return 1;
		}
		
		return value * factorial(value - 1);
	}
	
	public static int powerOf2(int range) {
		if (range < 1) {
			return 0;
		}
		
		if (range == 1) {
			System.out.println(1);
			
			return range;
		}
		
		int prev = powerOf2(range / 2);
		
		int current = 2 * prev;
		
		System.out.println(current);
		
		return current;
	}
	
	public static boolean binarySearch(int[] arr, int value) {
		return binarySearch(arr, value, 0, arr.length - 1);
	}
	
	public static boolean binarySearch(int[] arr, int value, int low, int high) {
		int middle = low + (high - low) / 2;
		
		if (low > high) {
			return false;
		}
		
		if (arr[middle] == value) {
			return true;
		}
		
		if (value < arr[middle]) {
			return binarySearch(arr, value, low, middle - 1);
		}
		
		return binarySearch(arr, value, middle + 1, high);
	}
	
	public static void main(String[] args) {
		Random gen = new Random();
		
		int value = gen.nextInt(100);
		
		System.out.println(value + " is prime: " + isPrime(value));
		
		int value2 = 5;
		
		System.out.println("Factorial of " + value2 + " is: " + factorial(value2));
		
		powerOf2(10);
		
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = i;
		}
		
		System.out.println(binarySearch(arr, 50));
	}
}
