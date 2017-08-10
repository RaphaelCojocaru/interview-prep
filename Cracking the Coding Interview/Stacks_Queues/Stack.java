package Stacks_Queues;

public class Stack {
	Node top;

	public Stack(int info) {
		top = new Node(info);
	}

	// insert at the head of the list
	public void push(int info) {
		Node aux = new Node(info);
		aux.next = top;
		top = aux;
	}

	// return the value from the head of the list
	public int pop() {
		int value = top.info;
		top = top.next;
		return value;
	}

	public boolean isEmpty() {
		if (top == null)
			return true;

		return false;
	}
}
