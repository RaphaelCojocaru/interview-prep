package LinkedLists;

import java.util.Stack;

// Implement an algorithm to find the kth to last element of a singly linked list.
public class Solution {
	static class Wrapper {
		public int value;
	}
	
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

	public static int kthToLast2(Node list, int k) {
		Node prev = list;

		// move the original node k positions to the end
		for (; list != null && k > 0; list = list.next, k--)
			;

		if (list == null)
			return -1;

		// go to the tail of the list
		for (; list.next != null; prev = prev.next, list = list.next)
			;

		return prev.info;
	}

	public static int kthToLastRecursive(Node list, int k, Wrapper wrapper) {
		if (list == null)
			return -1;

		int index = 1 + kthToLastRecursive(list.next, k, wrapper);

		if (index == k)
			wrapper.value = list.info;

		return index;
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);

		int k = 2;
		
		System.out.println(kthToLast(list, k));
		
		System.out.println(kthToLast2(list, k));
		
		Wrapper wrapper = new Wrapper();
		wrapper.value = -1;
		kthToLastRecursive(list, k, wrapper);
		System.out.println(wrapper.value);
	}
}
