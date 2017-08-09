package LinkedLists;

public class Node {
	public Node next;
	public int info;

	public Node(int info) {
		this.info = info;
	}

	public void append(int info) {
		Node aux = new Node(info);
		Node ant = null, p = this;

		for (; p != null; ant = p, p = p.next)
			;

		ant.next = aux;
	}
	
}
