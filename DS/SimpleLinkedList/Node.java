package SimpleLinkedList;

public class Node {
	public int info;
	public Node next;
	public Node tail;
	
	public Node(int info) {
		this.info = info;
	}
	
	public void append(int info) {
		Node aux = new Node(info);
		
		if (this.next == null)
			this.next = aux;
		else
			this.tail.next = aux;
		
		this.tail = aux;
	}
}
