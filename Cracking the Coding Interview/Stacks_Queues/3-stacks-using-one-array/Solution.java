package Stacks_Queues;

// Describe how you could use a single array to implement three stacks
public class Solution {
	private static int[] top;
	private static int[] array;
	private static int N;

	public static void push(int stack, int value) {
		// check for space
		if (top[stack - 1] == stack * N)
			return;

		// set the element
		array[top[stack - 1]] = value;

		// update the top
		top[stack - 1]++;
	}

	public static int pop(int stack) {
		// check if there is at least one element
		if (top[stack - 1] == 0)
			return -1;

		int value = array[top[stack - 1] - 1];

		// update the top of the stack
		top[stack - 1]--;

		// return the value
		return value;
	}

	public static void printStack(int stack) {
		int start = (stack - 1) * N;

		for (int i = start; i < top[stack - 1]; i++)
			System.out.print(array[i] + " ");
		
		System.out.println();
	}

	public static void main(String[] args) {
		// size of stacks
		N = 10;
		array = new int[N * 3];
		// set the top of each stack
		top = new int[3];
		top[0] = 0;
		top[1] = N;
		top[2] = 2 * N;
		
		push(1, 1);
		push(1, 2);
		push(1, 3);
		push(1, 4);
		push(1, 5);
		push(1, 6);
		push(1, 7);
		push(2, 5);
		push(2, 6);
		push(2, 7);
		push(1, 8);
		push(1, 9);
		push(1, 10);
		push(3, 8);
		push(3, 9);
		push(3, 10);
		System.out.println(pop(1));
		push(1, 11);
		
		printStack(1);
		printStack(2);
		printStack(3);
	}
}
