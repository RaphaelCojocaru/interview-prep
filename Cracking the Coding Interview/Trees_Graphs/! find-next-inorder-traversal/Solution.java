package Trees_Graphs;

// Write an algorithm to find the'next'node (i.e., in-order successor) of a given node
//in a binary search tree. You may assume that each node has a link to its parent.
public class Solution {
	public static Node leftMost(Node root) {
		if (root.left == null)
			return.root;
		
		return leftMost(root.left);
	}

	public static Node findNext(Node node) {
		// if current node has a right child, return the leftmost node in the right
		// subtree
		if (node.right != null)
			return leftMost(node.right);
		// if current node is a left child, then return the parent
		if (node.parent != null && node.parent.left == node)
			return node.parent;
		// if current node is a right child, then return the first parent being a
		// left-parent
		if (node.parent != null && node.parent.right == node) {
			Node parent = node.parent;
			while (parent.right == node) {
				parent = parent.parent;
				node = node.parent;
			}
			return parent;
		}

	}
}
