package LinkedLists;

// Implement an algorithm to delete a node in the middle of a singly linked list,
//given only access to that node.
public class Solution {

	public static void removeMiddle(Node list) {
		Node prev = null;

		// overwrite current info with the following info
		for (; list != null && list.next != null; prev = list, list = list.next)
			list.info = list.next.info;

		// remove the node at the tail of the list
		if (prev != null)
			prev.next = null;
	}

	public static void printList(Node list) {
		for (; list != null; list = list.next)
			System.out.print(list.info + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		Node head = list;
		// find the middle
		Node middle = list;
		for (; list != null && list.next != null; middle = middle.next, list = list.next.next)
			;

		removeMiddle(middle);
		printList(head);
	}
}
