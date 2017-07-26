package SimpleLinkedList;

import java.util.Stack;

public class Course1 {
	
	public static void printList(Node list) {
		for (; list != null; list = list.next)
			System.out.print(list.info + " ");
		System.out.println();
	}
	
	public static int length(Node list) {
		int length = 0;

		for (; list != null; list = list.next)
			length++;
		
		return length;
	}
	
	public static int lengthRecursive(Node list) {
		if (list == null)
			return 0;
		
		return 1 + lengthRecursive(list.next);
	}
	
	public static void printListReversed(Node list) {
		Stack<Node> stack = new Stack<Node>();
		
		for (; list != null; list = list.next)
			stack.push(list);

		while (stack.empty() == false) {
			Node peek = stack.pop();
			System.out.print(peek.info + " ");
		}
		System.out.println();
	}
	
	public static void printListReversedRecursive(Node list) {
		if (list == null)
			return;
		
		printListReversedRecursive(list.next);
		
		System.out.print(list.info + " ");

	}
	
	public static Node firstEven(Node list) {
		for (; list != null; list = list.next)
			if (list.info % 2 == 0)
				return list;
		
		return null;
	}
	
	public static Node lastEven(Node list) {
		Node last = null;
		for (; list != null; list = list.next)
			if (list.info % 2 == 0)
				last = list;
		
		return last;
	}
	
	public static Node insertAtBeginning(Node list, int data) {
		Node aux = new Node(data);
		
		aux.next = list;
		
		return aux;
	}
	
	public static Node insertAtEnd(Node list, int data) {
		Node prev = null, aux = new Node(data), head = list;
				
		for (; list != null; prev = list, list = list.next);
		
		if (prev != null)
			prev.next = aux;
		else
			return aux;
			
		return head;
	}
	
	public static void insertAfter(Node list, int data) {
		Node aux = new Node(data);
		
		// find the elem after that we need to insert
		for (; list != null; list = list.next)
			if (list.info == 3)
				break;
		
		// if no element meets the condition, then return the
		//original head
		if (list == null)
			return;
		
		aux.next = list.next;
		list.next = aux;
	}
	
	public static Node insertBefore(Node list, int data) {
		Node aux = new Node(data), prev = null, head = list;
		
		// find the elem before that we need to insert
		//and store the previous node
		for (; list != null; prev = list, list = list.next)
			if (list.info == 2)
				break;
		
		// if no element satisfies the condition, then return the
		//original head
		if (list == null)
			return head;
		
		// if prev is null, then insert at the beginning
		if (prev == null) {
			aux.next = head;
			return aux;
		}
		
		aux.next = list;
		prev.next = aux;
		return head;
	}
	
	public static void main(String[] args) {
		Node list = new Node(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		
		printList(list);
		System.out.println(length(list));
		System.out.println(lengthRecursive(list));

		printList(list);
		printListReversed(list);
		printListReversedRecursive(list);
		System.out.println();
		System.out.println(firstEven(list).info);
		System.out.println(lastEven(list).info);
		
		Node beginning = insertAtBeginning(list, 29);
		printList(list);
		printList(beginning);
		
		Node end = insertAtEnd(list, 29);
		printList(list);
		printList(end);
		
		insertAfter(list, 9);
		printList(list);
		
		Node before = insertBefore(list, 8);
		printList(before);
	}
}
