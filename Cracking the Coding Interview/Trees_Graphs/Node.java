package Trees_Graphs;

public class Node {
	public Node left, right;
	public int info;

	public Node(int value) {
		info = value;
	}

	public Node(int value, Node left, Node right) {
		info = value;
		this.left = left;
		this.right = right;
	}
}
