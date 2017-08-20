package LinkedLists;

import java.util.LinkedList;
import java.util.Stack;

// Implement a function to check if a linked list is a palindrome.
public class Solution {

	public static String isPalindrome(Node list) {
		// use a stack and a queue
		LinkedList<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		for (; list != null; list = list.next) {
			queue.add(list.info);
			stack.push(list.info);
		}

		// get an element from queue and one from the stack
		// and then compare them
		while (queue.isEmpty() == false) {
			int headElem = queue.removeFirst();
			int tailElem = stack.pop();

			if (headElem != tailElem)
				return "NO";
		}

		return "YES";
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(4);
		list.append(3);
		list.append(2);
		list.append(1);

		System.out.println(isPalindrome(list));
	}
}
