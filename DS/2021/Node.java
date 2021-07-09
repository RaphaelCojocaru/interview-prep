
public class Node {
	public int data;

	public Node next;
	private Node tail = null;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.valueOf(this.data);
	}

	public void append(int data) {
		Node aux = new Node(data);

		if (this.next == null) {
			this.next = aux;
		} else {
			this.tail.next = aux;
		}

		this.tail = aux;
	}

	public void append2(int data) { // without tail
		Node aux = new Node(data);
		Node last, prev = null;

		for (last = this; last != null; prev = last, last = last.next);

		if (this.next == null) {
			this.next = aux;
		} else {
			prev.next = aux;
		}
	}
}
