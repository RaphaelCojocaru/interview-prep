package LinkedLists;

import java.util.Random;

// Write code to partition a linked list around a value x, such that all nodes less than
//x come before all nodes greater than or equal to x.
public class Solution {
	public static Node insertAtHead(Node list, int value) {
		Node head = new Node(value);

		head.next = list;
		return head;
	}

	public static Node insertAtTail(Node list, int value) {
		Node prev = null, head = list;

		for (; list != null; prev = list, list = list.next)
			;

		if (prev == null)
			return insertAtHead(list, value);

		Node aux = new Node(value);

		prev.next = aux;

		return head;
	}

	public static Node partitionList(Node list, int x) {
		Node head = null;

		for (; list != null; list = list.next) {
			if (list.info < x)
				head = insertAtHead(head, list.info);
			else
				head = insertAtTail(head, list.info);
		}

		return head;
	}

	public static void printList(Node list) {
		for (; list != null; list = list.next)
			System.out.print(list.info + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		Random gen = new Random();
		Node list = new Node(gen.nextInt(10));
		list.append(gen.nextInt(10));
		list.append(gen.nextInt(10));
		list.append(gen.nextInt(10));
		list.append(gen.nextInt(10));
		list.append(gen.nextInt(10));
		list.append(gen.nextInt(10));
		list.append(gen.nextInt(10));
		list.append(gen.nextInt(10));
		list.append(gen.nextInt(10));

		int x = 5;
		printList(list);
		Node partition = partitionList(list, x);
		printList(partition);
	}
}
