
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Course4 {
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
	
	public static int countEvenWithSingleChild(TNode root) {
		if (root == null) {
			return 0;
		}
		
		if (root.left == null ^ root.right == null) {
			return 1 + countEvenWithSingleChild(root.left) + countEvenWithSingleChild(root.right);
		}
		
		return countEvenWithSingleChild(root.left) + countEvenWithSingleChild(root.right);
	}
	
	public static int averageOfLeavesOnLevel(TNode root, int level) {
		int[] counter = new int[2];
		
		count(root, counter, level);
		
		if (counter[1] != 0) {
			return counter[0] / counter[1];
		}
		
		return -1;
	}
	
	public static void count(TNode root, int[] counter, int level) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null && level == 0) {
			counter[0] += root.data;
			counter[1]++;
		}
		
		count(root.left, counter, level - 1);
		count(root.right, counter, level - 1);
	}
	
	public static boolean search(TNode root, int value) {
		if (root == null) {
			return false;
		}
		
		if (root.data == value) {
			return true;
		}
		
		return search(root.left, value) || search(root.right, value);
	}
	
	public static int searchLevel(TNode root, int value, int level) {
		int foundLeft;
		
		if (root == null) {
			return -1;
		}
		
		if (root.data == value) {
			return level;
		}
		
		foundLeft = searchLevel(root.left, value, level + 1);
		
		if (foundLeft >= 0) {
			return foundLeft;
		}
		
		return searchLevel(root.right, value, level + 1);
	}
	
	public static int searchLevel2(TNode root, int value) {
		int found;
		
		if (root == null) {
			return -1;
		}
		
		if (root.data == value) {
			return 0;
		}
		
		found = searchLevel2(root.left, value);
		
		if (found < 0) {
			found = searchLevel2(root.right, value);
			
			if (found < 0) {
				return found;
			}
		}
		
		return found + 1;
	}
	
	public static int max(TNode root) {
		if (root == null) {
			return -1;
		}
		
		return Math.max(Math.max(root.data, max(root.left)), max(root.right));
	}
	
	public static int maxCourse(TNode root) {
		int max, maxLeft, maxRight;
		
		if (root == null) {
			return -1;
		}
		
		max = root.data;
		
		maxLeft = maxCourse(root.left);
		
		if (maxLeft > max) {
			max = maxLeft;
		}
		
		maxRight = maxCourse(root.right);
		
		if (maxRight > max) {
			max = maxRight;
		}
		
		return max;
	}
	
	public static void inorder(TNode root) {
		if (root == null) {
			return;
		}
		
		inorder(root.left);
		
		System.out.print(root.data + " ");
		
		inorder(root.right);
	}
	
	public static int searchMin(TNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		
		if (root.left == null) {
			return root.data;
		}
		
		return searchMin(root.left);
	}
	
	public static int searchMax(TNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		
		if (root.right == null) {
			return root.data;
		}
		
		return searchMax(root.right);
	}
	
	public static void insert(TNode root, int value) {
		if (root == null || root.data == value) {
			return;
		}
		
		if (value < root.data) {
			if (root.left == null) {
				TNode aux = new TNode(value);
				
				root.left = aux;
				
				return;
			} else {
				insert(root.left, value);
			}
		}
		
		if (value > root.data) {
			if (root.right == null) {
				TNode aux = new TNode(value);
				
				root.right = aux;
				
				return;
			} else {
				insert(root.right, value);
			}
		}
	}
	
	public static TNode insert2(TNode root, int data) {
		TNode aux;
		
        if (root == null) {
            return new TNode(data);
        } else {
            if (data <= root.data) {
                aux = insert2(root.left, data);
                root.left = aux;
            } else {
                aux = insert2(root.right, data);
                root.right = aux;
            }
        }
        
        return root;
    }
	
	public static void main(String[] args) {
		TNode leaf1 = new TNode(4);
		TNode leaf2 = new TNode(7);
		TNode leaf3 = new TNode(8);
		
		TNode node1 = new TNode(5, leaf2, leaf3);
		TNode node2 = new TNode(6, null, null);
		TNode node3 = new TNode(2, leaf1, node1);
		TNode node4 = new TNode(3, node2, null);
		
		TNode root = new TNode(1, node3, node4);
		
		System.out.println("Performing BFS:");
		BFS(root);
		System.out.println();
		
		System.out.println("Numer of even nodes with single child: " + countEvenWithSingleChild(root));
		
		System.out.println("Average of leaves on level 2: " + averageOfLeavesOnLevel(root, 2));
		
		System.out.println("Searching value 4 in tree: " +  search(root, 4));
		
		System.out.println("Found value 5 on level: " +  searchLevel(root, 5, 0));
		
		System.out.println("Max value in the tree: " + max(root));
		
		System.out.println("Max value in the tree (course version): " + max(root));
		
		TNode leaf11 = new TNode(8);
		TNode leaf12 = new TNode(15);
		TNode leaf13 = new TNode(75);
		
		TNode node11 = new TNode(10, leaf11, leaf12);
		TNode node12 = new TNode(80, leaf13, null);
		TNode node13 = new TNode(90, node12, null);
		
		TNode root2 = new TNode(70, node11, node13);
		
		System.out.println("Performing Preorder:");
		inorder(root2);
		System.out.println();
		
		System.out.println("Min value in the search tree: " + searchMin(root2));
		
		System.out.println("Max value in the search tree: " + searchMax(root2));
		
		insert(root2, 100);
		
		insert(root2, 85);
		
		System.out.println("Performing Preorder:");
		inorder(root2);
		System.out.println();
		 
	}
}
