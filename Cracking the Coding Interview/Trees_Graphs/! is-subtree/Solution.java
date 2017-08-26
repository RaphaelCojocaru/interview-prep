package Trees_Graphs;

import java.util.ArrayList;

// You have two very large binary trees: Tl, with millions of nodes, and T2, with
//hundreds of nodes. Create an algorithm to decide if T2 is a subtree of Tl.
public class Solution {

	public static void inOrder(Node root, ArrayList<Integer> list) {
		if (root == null) {
			list.add(-1);
			return;
		}

		inOrder(root.left, list);
		list.add(root.info);
		inOrder(root.right, list);
	}

	public static void preOrder(Node root, ArrayList<Integer> list) {
		if (root == null) {
			list.add(-1);
			return;
		}

		list.add(root.info);
		preOrder(root.left, list);
		preOrder(root.right, list);
	}

	public static String isSubtree(Node subtree, Node root) {
		// build the in-order/pre-order lists of nodes from the subtree
		ArrayList<Integer> list1 = new ArrayList<>();
		inOrder(subtree, list1);
		ArrayList<Integer> list1_ = new ArrayList<>();
		preOrder(subtree, list1_);
		// build the in-order/pre-order lists of nodes from the entire tree
		ArrayList<Integer> list2 = new ArrayList<>();
		inOrder(root, list2);
		ArrayList<Integer> list2_ = new ArrayList<>();
		preOrder(root, list2_);

		if (list1.size() > list2.size() || list1_.size() > list2_.size())
			return "NO";

		boolean equal, inOrder = false;
		// check for in-order
		for (int i = 0; i <= list2.size() - list1.size(); i++) {
			equal = true;
			for (int j = 0; j < list1.size(); j++)
				if (list2.get(i + j) != list1.get(j)) {
					equal = false;
					break;
				}
			// check if the second list was entirely traversed
			if (equal == true) {
				inOrder = true;
				break;
			}
		}

		if (inOrder == false)
			return "NO";

		// check for pre-order
		for (int i = 0; i <= list2_.size() - list1_.size(); i++) {
			equal = true;
			for (int j = 0; j < list1_.size(); j++)
				if (list2_.get(i + j) != list1_.get(j)) {
					equal = false;
					break;
				}
			// check if the second list was entirely traversed
			if (equal == true)
				return "YES";
		}
		System.out.println(list1_);
		System.out.println(list2_);
		return "NO";
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

		System.out.println(isSubtree(Bleaf8, Bleaf9));
	}
}
