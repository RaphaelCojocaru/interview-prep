package LinkedLists;

import java.util.Stack;

// You have two numbers represented by a linked list, where each node contains a
//single digit. The digits are stored in reverse order, such that the Ts digit is at the
//head of the list. Write a function that adds the two numbers and returns the sum
//as a linked list.
public class Solution2 {
	// Suppose the digits are stored in forward order. Repeat the above problem.
	public static Node sumLists(Node num1, Node num2) {
		Node head = null, tail = null, aux;
		boolean carry = false;
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		Stack<Node> result = new Stack<Node>();

		for (; num1 != null; num1 = num1.next)
			stack1.push(num1);
		for (; num2 != null; num2 = num2.next)
			stack2.push(num2);

		while (stack1.isEmpty() == false && stack2.isEmpty() == false) {
			num1 = stack1.pop();
			num2 = stack2.pop();
			// compute the sum
			int sum = num1.info + num2.info;
			if (carry == true)
				sum++;
			// set the carry flag
			if (sum > 9)
				carry = true;
			else
				carry = false;
			// create new node and append it to the result list
			aux = new Node(sum % 10);
			result.push(aux);
		}

		// add the remaining digits of number 1
		while (stack1.isEmpty() == false) {
			num1 = stack1.pop();
			// compute the sum
			int sum = num1.info;
			if (carry == true)
				sum++;
			// set the carry flag
			if (sum > 9)
				carry = true;
			else
				carry = false;
			// create new node and append it to the result list
			aux = new Node(sum % 10);
			result.push(aux);
		}
		// add the remaining digits of number 2
		while (stack2.isEmpty() == false) {
			num2 = stack2.pop();
			// compute the sum
			int sum = num2.info;
			if (carry == true)
				sum++;
			// set the carry flag
			if (sum > 9)
				carry = true;
			else
				carry = false;
			// create new node and append it to the result list
			aux = new Node(sum % 10);
			result.push(aux);
		}

		if (carry == true) {
			aux = new Node(1);
			result.push(aux);
		}

		while (result.isEmpty() == false) {
			aux = result.pop();
			if (head == null)
				head = aux;
			else
				tail.next = aux;
			tail = aux;
		}

		return head;
	}

	public static void printList(Node list) {
		for (; list != null; list = list.next)
			System.out.print(list.info + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		Node num1 = new Node(6);
		num1.append(1);
		num1.append(7);

		Node num2 = new Node(2);
		num2.append(9);
		num2.append(5);

		Node sum = sumLists(num1, num2);
		printList(sum);
	}
}
