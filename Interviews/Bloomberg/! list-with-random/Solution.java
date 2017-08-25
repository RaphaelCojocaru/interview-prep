package list-with-random;

import java.util.HashMap;

public class Solution {
	static class Node {
		private int info;
		private Node next;
		private Node random;

		public Node() {
		}

		public Node(int info) {
			this.info = info;
		}

		public void append(int value) {
			Node aux = new Node(value);
			Node ant = null, p = this;

			for (; p != null; ant = p, p = p.next)
				;

			ant.next = aux;
		}
	}

	public static Node deepCopy(Node list) {
		Node head = null, tail = null, p = list, p2;
		HashMap<Node, Node> map = new HashMap<Node, Node>();

		// create the deep copy of the list by doubling each element
		for (; p != null; p = p.next) {
			// create a new node
			Node aux = new Node(p.info * 2);
			// add the node to the new created list
			if (head == null)
				head = aux;
			else
				tail.next = aux;

			tail = aux;

			// put the nodes into an hash entry
			map.put(p, aux);
		}
		
		// perform a new traversal in order to set all the random values
		p = list;
		p2 = head;
		for (; p != null; p = p.next, p2 = p2.next) {
			p2.random = map.get(p.random);
		}
		
		return head;
	}

	public static void printList(Node list) {
		Node p = list;

		for (; p != null; p = p.next)
			if (p.random != null)
				System.out.print("(" + p.info + " " + p.random.info + ")" + " ");
			else
				System.out.print("(" + p.info + " -" + ")" + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.append(2);
		list.append(3);
		list.append(4);

		Node n1 = list;
		Node n2 = n1.next;
		Node n3 = n2.next;
		Node n4 = n3.next;

		n1.random = n3;
		n2.random = n4;
		n3.random = n1;
		n4.random = n2;
		printList(list);

		Node copy = deepCopy(list);
		printList(copy);
	}
}
