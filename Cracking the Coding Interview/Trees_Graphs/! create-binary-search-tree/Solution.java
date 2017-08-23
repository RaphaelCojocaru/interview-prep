package Trees_Graphs;

// Given a sorted (increasing order) array with unique integer elements, write an
//algorithm to create a binary search tree with minimal height.
public class Solution {
	public static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.info + " ");
		inOrder(root.right);
	}

	public static Node createBST(int[] arr, int start, int end) {
		int middle = start + (end - start) / 2;
		if (start > end)
			return null;

		return new Node(arr[middle], createBST(arr, start, middle - 1), createBST(arr, middle + 1, end));
	}

	public static void main(String[] args) {
		int[] arr = new int[20];
		for (int i = 0; i < 20; i++)
			arr[i] = i + 1;

		Node tree = createBST(arr, 0, 19);
		inOrder(tree);
	}
}
