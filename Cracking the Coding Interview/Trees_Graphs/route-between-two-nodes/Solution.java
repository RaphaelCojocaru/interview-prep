package Trees_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Given a directed graph, design an algorithm to find out whether there is a route
//between two nodes.
public class Solution {
	private static ArrayList<ArrayList<Integer>> edges;

	// perform a DFS
	public static boolean existsRouteDFS(int start, int end, boolean[] visited) {

		if (start == end)
			return true;

		visited[start] = true;

		for (int neighbour : edges.get(start)) {
			if (visited[neighbour] == false && existsRouteDFS(neighbour, end, visited) == true)
				return true;
		}

		return false;
	}

	// perform a BFS
	public static boolean existsRouteBFS(int start, int end) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[edges.size()];

		queue.add(start);
		visited[start] = true;

		while (queue.isEmpty() == false) {
			int node = queue.poll();

			for (int neighbour : edges.get(node)) {
				if (neighbour == end)
					return true;
				if (visited[neighbour] == false) {
					queue.add(neighbour);
					visited[neighbour] = true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		boolean[] visited = new boolean[vertices];
		int edgesNo = sc.nextInt();

		// create the adjacency list
		edges = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < vertices; i++)
			edges.add(new ArrayList<Integer>());

		// read and add the edges
		for (int i = 0; i < edgesNo; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			edges.get(start).add(end);
			edges.get(end).add(start);
		}

		System.out.println(existsRouteBFS(1, 3));

		System.out.println(existsRouteDFS(1, 3, visited));
		sc.close();
	}

}
