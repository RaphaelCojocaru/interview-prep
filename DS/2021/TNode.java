
public class TNode {
	public int data;
	
	public TNode left;
	public TNode right;

	public TNode(int data) {
		this.data = data;
	}
	
	public TNode(int data, TNode left, TNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
