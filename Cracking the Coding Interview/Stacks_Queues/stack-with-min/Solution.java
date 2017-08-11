package Stacks_Queues;

import java.util.Stack;
import java.util.PriorityQueue;

// How would you design a stack which, in addition to push and pop, also has a
//function min which returns the minimum element? Push, pop and min should
//all operate in O(1) time.
public class Solution {
	static class MyStack {
		Stack<Integer> stack;
		PriorityQueue<Integer> queue;

		public MyStack() {
			stack = new Stack<Integer>();
			queue = new PriorityQueue<Integer>();
		}

		public void push(int value) {
			stack.push(value);
			queue.add(value);
		}

		public int pop() {
			int value = stack.pop();
			queue.remove(value);
			return value;
		}
		
		public int minValue() {
			return queue.peek();
		}
	}

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(4);
		myStack.push(5);
		myStack.push(3);
		myStack.push(5);
		myStack.push(2);
		myStack.push(3);
		myStack.push(1);
		
		System.out.println(myStack.minValue());
		myStack.pop();
		System.out.println(myStack.minValue());

	}
}
