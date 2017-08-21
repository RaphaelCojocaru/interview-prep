package Stacks_Queues;

// Write a program to sort a stack in ascending order (with biggest items on top).
// You may use at most one additional stack to hold items, supporting
//the following operations: push, pop, peek, and isEmpty.
public class Solution {

	public static void printStack(Stack stack) {
		Stack aux = new Stack(-1);
		aux.pop();

		while (stack.isEmpty() == false) {
			int value = stack.pop();
			System.out.print(value + " ");
			aux.push(value);
		}

		while (aux.isEmpty() == false) {
			int value = aux.pop();
			stack.push(value);
		}

		System.out.println();
	}

	public static void sortStack(Stack stack) {
		// create empty auxiliary stack
		Stack aux = new Stack(-1);
		aux.pop();

		if (stack.isEmpty() == true)
			return;

		int top;
		// sort the original stack into the auxiliary one
		while (stack.isEmpty() == false) {
			// get the top element of the stack
			top = stack.pop();

			// find the place to insert in the auxiliary stack in decreasing order
			while (aux.isEmpty() == false && aux.peek() < top) {
				int value = aux.pop();
				stack.push(value);
			}

			// insert the top into the auxiliary stack
			aux.push(top);

			// put the elements back into the auxiliary stack
			while (stack.isEmpty() == false && stack.peek() < aux.peek()) {
				int value = stack.pop();
				aux.push(value);
			}
		}

		// reverse the auxiliary stack
		while (aux.isEmpty() == false) {
			int value = aux.pop();
			stack.push(value);
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack(3);
		stack.push(2);
		stack.push(6);
		stack.push(5);
		stack.push(1);
		stack.push(9);

		printStack(stack);
		sortStack(stack);
		printStack(stack);
	}
}
