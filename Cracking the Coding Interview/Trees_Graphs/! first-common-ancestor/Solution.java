package Trees_Graphs;

// Design an algorithm and write code to find the first common ancestor of two
//nodes in a binary tree
public class Solution {

	public static boolean withinTree(Node tree, Node node) {
		if (tree == null || node == null)
			return false;

		if (tree.info == node.info)
			return true;

		if (withinTree(tree.left, node) == true)
			return true;

		return withinTree(tree.right, node);
	}

	public static Node firstCommonAncestor(Node root, Node n1, Node n2) {
		if (root == null || n1 == null || n2 == null)
			return null;

		// check if one of the nodes is a child of the other one
		if (withinTree(n1, n2))
			return n1;
		if (withinTree(n2, n1))
			return n2;
		/* or like this:
		 *  if (root.info == n1.info || root.info == n2.info)
		 *  	return root;
		 */
		// check if both nodes are in the left subtree
		boolean leftN1 = withinTree(root.left, n1);
		boolean leftN2 = withinTree(root.left, n2);
		// if n1 and n2 are in different subtrees, return the root
		if (leftN1 != leftN2)
			return root;
		else if (leftN1 == true && leftN2 == true)
			return firstCommonAncestor(root.left, n1, n2);
		else
			return firstCommonAncestor(root.right, n1, n2);
	}

	public static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.info + " ");
		inOrder(root.right);
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

		Node firstCommonAncestor = firstCommonAncestor(tree, Bleaf9, leaf9);
		if (firstCommonAncestor != null)
			System.out.println("First common ancestor is: " + firstCommonAncestor.info);
		else
			System.out.println("There is no common ancestor for those two nodes!");
	}
}
