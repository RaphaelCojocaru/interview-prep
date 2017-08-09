package LinkedLists;

// You have two numbers represented by a linked list, where each node contains a
//single digit. The digits are stored in reverse order, such that the Ts digit is at the
//head of the list. Write a function that adds the two numbers and returns the sum
//as a linked list.
public class Solution {
	public static Node sumLists(Node num1, Node num2) {
		Node head = null, tail = null, aux;
		boolean carry = false;

		for (; num1 != null && num2 != null; num1 = num1.next, num2 = num2.next) {
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
			if (head == null)
				head = aux;
			else
				tail.next = aux;
			tail = aux;
		}

		// add the remaining digits of number 1
		for (; num1 != null; num1 = num1.next) {
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
			if (head == null)
				head = aux;
			else
				tail.next = aux;
			tail = aux;
		}
		// add the remaining digits of number 2
		for (; num2 != null; num2 = num2.next) {
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
			if (head == null)
				head = aux;
			else
				tail.next = aux;
			tail = aux;
		}		
		
		if (carry == true) {
			aux = new Node(1);
			tail.next = aux;
		}
		
		return head;
	}

	public static void printList(Node list) {
		for (; list != null; list = list.next)
			System.out.print(list.info + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		Node num1 = new Node(7);
		num1.append(1);
		num1.append(6);

		Node num2 = new Node(5);
		num2.append(9);
		num2.append(2);

		Node sum = sumLists(num1, num2);
		printList(sum);
	}
}
