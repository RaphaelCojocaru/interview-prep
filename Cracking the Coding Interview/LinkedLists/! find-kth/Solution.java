package LinkedLists;

import java.util.Stack;

// Implement an algorithm to find the kth to last element of a singly linked list.
public class Solution {
	public static int kthToLast(Node list, int k) {
		Stack<Integer> stack = new Stack<Integer>();

		for (; list != null; list = list.next)
			stack.push(list.info);

		while (stack.isEmpty() == false && k > 0) {
			stack.pop();
			k--;
		}

		if (stack.isEmpty() == false)
			return stack.pop();

		return -1;
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		System.out.println(kthToLast(list, 5));
	}
}
