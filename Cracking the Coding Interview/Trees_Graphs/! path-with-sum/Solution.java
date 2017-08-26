package Trees_Graphs;

import java.util.ArrayList;

// You are given a binary tree in which each node contains a value. Design an algorithm
//to print all paths which sum to a given value. The path does not need to
//start or end at the root or a leaf.
public class Solution {
	public static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.info + " ");
		inOrder(root.right);
	}

	// use a list to store all the values from each path
	public static void printPath(Node tree, ArrayList<Integer> list, int sum) {
		if (tree == null)
			return;

		// add the current value
		list.add(tree.info);

		// compute the current sum
		int mySum = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			mySum += list.get(i);
			// if mySum equals to sum given as a parameter, then print the path
			if (mySum == sum) {
				for (int j = list.size() - 1; j >= i; j--)
					System.out.print(list.get(j) + " ");
				System.out.println();
			}
		}

		// check for sum on left and right
		printPath(tree.left, list, sum);
		printPath(tree.right, list, sum);

		// remove the last/current node from the list
		list.remove(list.size() - 1);
	}

	// use a simple array to store all the values from each path
	public static void printPath2(Node tree, int[] array, int level, int sum) {
		if (tree == null)
			return;

		// add the current value
		array[level] = tree.info;

		// compute the current sum
		int mySum = 0;
		for (int i = level; i >= 0; i--) {
			mySum += array[i];
			// if mySum equals to sum given as a parameter, then print the path
			if (mySum == sum) {
				for (int j = level; j >= i; j--)
					System.out.print(array[j] + " ");
				System.out.println();
			}
		}

		// check for sum on left and right
		printPath2(tree.left, array, level + 1, sum);
		printPath2(tree.right, array, level + 1, sum);

		// remove the last/current node from the list
		// list.remove(list.size() - 1);
	}

	public static int computeDepth(Node root) {
		if (root == null)
			return 1;

		int left = computeDepth(root.left);
		int right = computeDepth(root.right);

		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		Node leaf1 = new Node(0);
		Node leaf21 = new Node(-2);
		Node leaf2 = new Node(4, leaf21, null);
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

		// inOrder(tree);
		//System.out.println();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 20;
		printPath(tree, list, sum);

		System.out.println();
		
		int depth = computeDepth(tree);
		int[] array = new int[depth];
		printPath2(tree, array, 0, sum);
	}
}
