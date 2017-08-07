package LinkedLists;

import java.util.HashSet;
import java.util.Random;

// Write code to remove duplicates from an unsorted linked list.
public class Solution {
	public static Node removeDuplicates(Node list) {
		Node head = list, prev = null;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (; list != null; list = list.next) {
			if (set.contains(list.info) == true) {
				prev.next = list.next;	// do not update the prev node
			} else {
				set.add(list.info);
				prev = list;
			}
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

		printList(list);
		Node removed = removeDuplicates(list);
		printList(removed);
	}
}
