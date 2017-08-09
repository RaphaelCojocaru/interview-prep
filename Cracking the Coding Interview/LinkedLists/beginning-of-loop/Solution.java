package LinkedLists;

import java.util.HashSet;

// Given a circular linked list, implement an algorithm which returns the node at
//the beginning of the loop
public class Solution {
	public static Node beginningOfLoop(Node list) {
		HashSet<Node> nodes = new HashSet<Node>();
		
		for (; list != null; list = list.next) {
			if (nodes.contains(list) == true)
				return list;
			else 
				nodes.add(list);
		}
		
		return null;
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		Node n5 = new Node(6);

		list.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;

		Node beginningOfLoop = beginningOfLoop(list);
		if (beginningOfLoop != null)
			System.out.println(beginningOfLoop.info);
	}
}
