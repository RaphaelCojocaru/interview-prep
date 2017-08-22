package Trees_Graphs;

// Implement a function to check if a binary tree is balanced. For the purposes of this
//question, a balanced tree is defined to be a tree such that the heights of the two
//subtrees of any node never differ by more than one.
public class Solution {
	public static int getHeight(Node root) {
		if (root == null)
			return 0;

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		return Math.max(left, right) + 1;
	}

	public static boolean isBalanced(Node root) {
		if (root == null)
			return true;

		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
			return false;

		if (isBalanced(root.left) == false)
			return false;

		return isBalanced(root.right);

		// return isBalanced(root.left) & isBalanced(root.right)
	}

	// More optimally solution
	public static int checkHeight(Node root) {
		if (root == null)
			return 0;

		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1)
			return -1;

		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1)
			return -1;

		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		Node n10 = new Node(10);
		Node n9 = new Node(9);
		Node n8 = new Node(8, n9, n10);
		Node n7 = new Node(7);
		Node not = new Node(29);
		Node n6 = new Node(6, not, null);
		Node n5 = new Node(5, n6, n7);
		Node n4 = new Node(4);
		Node n3 = new Node(3, n4, null);
		Node n2 = new Node(2, n5, n8);
		Node n1 = new Node(1, n2, n3);

		System.out.println(isBalanced(n1));
		System.out.println(checkHeight(n1));
	}
}
