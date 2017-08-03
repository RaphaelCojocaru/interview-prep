package Twitter;
/*
 * Complete the function below.
 */

public class Solution3 {
	static int getDistance(String s1, String s2) {
		int count = 0;

		for (int i = 0; i < s1.length(); i++)
			if (s1.charAt(i) != s2.charAt(i))
				count++;

		return count;
	}

	// Final solution
	static int findMutationDistance2(String start, String end, String[] bank) {
		int count = 0;
		boolean[] visited = new boolean[bank.length];

		while (getDistance(start, end) != 0) {
			boolean found = false;
			for (int i = 0; i < bank.length; i++) {
				String model = bank[i];
				if (getDistance(start, model) == 1 && getDistance(start, end) > getDistance(model, end)
						&& visited[i] == false) {
					start = new String(model);
					visited[i] = true;
					count++;
					found = true;
				}
			}

			if (found == false)
				return count;
		}

		return count;
	}

    // Recursion
	static int findMutationDistance(String start, String end, String[] bank) {
		boolean[] visited = new boolean[bank.length];

		for (int i = 0; i < visited.length; i++)
			visited[i] = false;

		return findMutationDistance_aux(start, end, bank, visited);
	}

	static int findMutationDistance_aux(String start, String end, String[] bank, boolean[] visited) {
		int count = 0;

		if (getDistance(start, end) == 0)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < bank.length; i++) {
			String model = bank[i];
			if (visited[i] == false && getDistance(start, model) == 1
					&& getDistance(start, end) > getDistance(model, end)) {
				String new_start = new String(model);
				boolean[] new_visited = visited.clone();
				new_visited[i] = true;
				count = 1 + findMutationDistance_aux(new_start, end, bank, new_visited);
				if (count < min)
					min = count;
			}
		}

		return min;
	}
}