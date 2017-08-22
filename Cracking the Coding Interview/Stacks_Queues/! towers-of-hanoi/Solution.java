package Stacks_Queues;

// Solve the Towers of Hanoi problem
public class Solution {
	private static Stack[] towers;

	public static void solveHanoi(int n, int a, int b, int c) {
		if (n <= 0)
			return;

		// move n - 1 elements from tower a to b using c
		solveHanoi(n - 1, a, c, b);
		// move last element from tower a to tobwer c
		int value = towers[a].pop();
		towers[c].push(value);
		// move n - 1 elements from tower b to c using a
		solveHanoi(n - 1, b, a, c);
	}

	public static void main(String[] args) {
		towers = new Stack[3];
		// create the first tower and put the elements inside
		towers[0] = new Stack(5);
		towers[0].push(4);
		towers[0].push(3);
		towers[0].push(2);
		towers[0].push(1);
		// create two empty towers
		towers[1] = new Stack(0);
		towers[1].pop();
		towers[2] = new Stack(0);
		towers[2].pop();

		solveHanoi(5, 0, 1, 2);

		System.out.println("Tower 1 is empty: " + towers[0].isEmpty());
		System.out.println("Tower 2 is empty: " + towers[1].isEmpty());
		System.out.println("Tower 3 is empty: " + towers[2].isEmpty());

		while (towers[2].isEmpty() == false)
			System.out.println(towers[2].pop());
	}
}
