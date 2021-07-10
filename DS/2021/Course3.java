
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Course3 {
	public static int height(TNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static int cardinal(TNode root) {
		if (root == null) {
			return 0;
		}
		
		return 1 + cardinal(root.left) + cardinal(root.right);
	}
	
	public static void preorder(TNode root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		
		preorder(root.left);
		
		preorder(root.right);
	}
	
	public static void postorder(TNode root) {
		if (root == null) {
			return;
		}
		
		postorder(root.left);
		
		postorder(root.right);
		
		System.out.print(root.data + " ");
	}
	
	public static void inorder(TNode root) {
		if (root == null) {
			return;
		}
		
		inorder(root.left);
		
		System.out.print(root.data + " ");
		
		inorder(root.right);
	}
	
	public static int countEvenNodes(TNode root) {
		int isEven = 0;
		
		if (root == null) {
			return 0;
		}
		
		if (root.data % 2 == 0) {
			isEven = 1;
		}
		
		return isEven + countEvenNodes(root.left) + countEvenNodes(root.right);
	}
	
	public static void BFS(TNode root) {
		TNode current;
		Queue<TNode> queue = new LinkedList<TNode>();
		
		queue.add(root);
		
		while (!queue.isEmpty()) {
			current = queue.remove();
			
			System.out.print(current.data + " ");
			
			if (current.left != null) {
				queue.add(current.left);	
			}
			
			if (current.right != null) {
				queue.add(current.right);	
			}
		}
	}
	
	public static float percentageOfEvenNodes(TNode root) {
		// use arr as a counter: arr[0] == even nodes, arr[1] == total nodes
		int[] counter = new int[2];
		
		count(root, counter);
		
		return (float) 100 * counter[0] / counter[1];
	}
	
	public static void count(TNode root, int[] counter) {
		if (root == null) {
			return;
		}
		
		if (root.data % 2 == 0) {
			counter[0]++;
		}
		
		counter[1]++;
		
		count(root.left, counter);
		
		count(root.right, counter);
	}
	
	
	public static float percentageOfEvenNodesOnLevel(TNode root, int level) {
		int[] counter = new int[2];
		
		countWithLevel(root, counter, level);
		
		return (float) 100 * counter[0] / counter[1];
	}
	
	public static void countWithLevel(TNode root, int[] counter, int level) {
		if (root == null) {
			return;
		}
		
		if (root.data % 2 == 0 && level == 0) {
			counter[0]++;
		}
		
		counter[1]++;
		
		countWithLevel(root.left, counter, level - 1);
		
		countWithLevel(root.right, counter, level - 1);
	}
	
	public static void main(String[] args) {
		TNode leaf1 = new TNode(4);
		TNode leaf2 = new TNode(7);
		TNode leaf3 = new TNode(8);
		TNode leaf4 = new TNode(9);
		
		TNode node1 = new TNode(5, leaf2, leaf3);
		TNode node2 = new TNode(6, null, leaf4);
		TNode node3 = new TNode(2, leaf1, node1);
		TNode node4 = new TNode(3, node2, null);
		
		TNode root = new TNode(1, node3, node4);
		
		System.out.println("The height of the tree is = " + height(root));
		
		System.out.println("The no of nodes is = " + cardinal(root));
		
		System.out.println("Preorder print:");
		preorder(root);
		System.out.println();
		System.out.println("Postorder print:");
		postorder(root);
		System.out.println();
		System.out.println("Inorder print:");
		inorder(root);
		System.out.println();
		
		System.out.println("The number of even nodes = " + countEvenNodes(root));		
		
		System.out.println("Performing BFS:");
		BFS(root);
		System.out.println();
		
		System.out.println("The percentage of even nodes = " + percentageOfEvenNodes(root));
		
		System.out.println("The percentage of even nodes on level 0 = " + percentageOfEvenNodesOnLevel(root, 2));
		
	}
}
