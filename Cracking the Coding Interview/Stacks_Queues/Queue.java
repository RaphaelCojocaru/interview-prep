package Stacks_Queues;

public class Queue {
	Node head, tail;

	public Queue(int info) {
		head = new Node(info);
	}
	
	// add value at the end of the list
	public void enqueue(int value) {
		Node aux = new Node(value);
		// update the links
		if (head.next == null)
			head.next = aux;
		else
			tail.next = aux;
		// update the tail
		tail = aux;
	}
	
	// return value from the head of the list
	public int dequeue() {
		int value = head.info;
		head = head.next;
		return value;
	}
	
	public boolean isEmpty() { 
		if (head == null)
			return true;
		
		return false;
	}
}
