package Trees_Graphs;

import java.util.LinkedList;
import java.util.Queue;

// Given a binary tree, design an algorithm which creates a linked list of all the
//nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
public class Solution {
	public static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.info + " ");
		inOrder(root.right);
	}

	// perform a BFS to go through all the depths
	public static LinkedList<LinkedList<Integer>> listsOnDepth(Node root) {
		LinkedList<LinkedList<Integer>> depths = new LinkedList<>();
		LinkedList<Integer> depth = null;
		Queue<Node> children = new LinkedList<Node>();
		Queue<Node> parents = new LinkedList<Node>();
		parents.add(root);

		while (true) {
			// variable used to create a new list for a new depth
			boolean first = true;
			// put the current parents into a list
			while (parents.isEmpty() == false) {
				Node parent = parents.poll();
				if (first == true) {
					depth = new LinkedList<Integer>();
					first = false;
				}
				depth.add(parent.info);
				// add all the children
				if (parent.left != null)
					children.add(parent.left);
				if (parent.right != null)
					children.add(parent.right);
			}
			// add the depth to the result
			depths.add(depth);
			// if no children left, then break and return
			if (children.isEmpty())
				break;
			// children become parents
			while (children.isEmpty() == false)
				parents.add(children.poll());
		}

		return depths;
	}

	public static void main(String[] args) {
		Node leaf1 = new Node(1);
		Node leaf2 = new Node(4);
		Node leaf3 = new Node(6);
		Node leaf4 = new Node(9);
		Node leaf5 = new Node(11);
		Node leaf6 = new Node(14);
		Node leaf7 = new Node(16);
		Node leaf8 = new Node(18);
		Node leaf9 = new Node(20);

		Node Bleaf1 = new Node(2, leaf1, null);
		Node Bleaf2 = new Node(3, Bleaf1, leaf2);
		Node Bleaf3 = new Node(8, null, leaf4);
		Node Bleaf4 = new Node(7, leaf3, Bleaf3);
		Node Bleaf5 = new Node(5, Bleaf2, Bleaf4);
		Node Bleaf6 = new Node(13, null, leaf6);
		Node Bleaf7 = new Node(12, leaf5, Bleaf6);
		Node Bleaf8 = new Node(19, leaf8, leaf9);
		Node Bleaf9 = new Node(17, leaf7, Bleaf8);
		Node Bleaf10 = new Node(15, Bleaf7, Bleaf9);
		Node tree = new Node(10, Bleaf5, Bleaf10);

		inOrder(tree);
		System.out.println();
		LinkedList<LinkedList<Integer>> depths = listsOnDepth(tree);
		while (depths.isEmpty() == false) {
			LinkedList<Integer> depth = depths.removeFirst();
			for (int i : depth)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}
