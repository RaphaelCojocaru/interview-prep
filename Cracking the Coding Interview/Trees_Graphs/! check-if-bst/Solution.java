package Trees_Graphs;

// Implement a function to check if a binary tree is a binary search tree.
public class Solution {
	// method for determining wheter a binary tree is BST or not
	// use a min and max parameters to compare the current value
	public static boolean isBST(Node root, int min, int max) {
		if (root == null)
			return true;

		if (root.info < min || root.info > max)
			return false;

		return isBST(root.left, min, root.info) && isBST(root.right, root.info, max);
	}
	// An in-order traversal, copy the elements to an array,
	//and then check to see if the array is sorted.
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

		System.out.println(isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}
