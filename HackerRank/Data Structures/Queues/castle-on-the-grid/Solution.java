import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    static class Point {
        public int x;
        public int y;
        public int distance;
        public boolean visited;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.visited = false;
        }
    }

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER startX
     *  3. INTEGER startY
     *  4. INTEGER goalX
     *  5. INTEGER goalY
     */

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();
        int m = grid.get(0).length();
        int furthestNeighbour;
        Queue<Point> queue = new LinkedList<>();
        Point current;
        HashSet<String> visited = new HashSet<>();

        queue.add(new Point(startX, startY, 0));

        while (!queue.isEmpty()) {
            current = queue.remove();

            visited.add(current.x + "" + current.y);

            if (current.x == goalX && current.y == goalY) {
                return current.distance;
            }

            // cells to right
            furthestNeighbour = current.y;
            for (int i = current.y; i < m; i++) {
                if (grid.get(current.x).charAt(i) != 'X') {
                    if (!visited.contains(current.x + "" + i)) {
                        furthestNeighbour = i;
                    }
                } else {
                    break;
                }
            }

            if (furthestNeighbour != current.y) {
                queue.add(new Point(current.x, furthestNeighbour, current.distance + 1));
            }

            // cells to left
            furthestNeighbour = current.y;
            for (int i = current.y; i >= 0; i--) {
                if (grid.get(current.x).charAt(i) != 'X') {
                    if (!visited.contains(current.x + "" + i)) {
                        furthestNeighbour = i;
                    }
                } else {
                    break;
                }
            }

            if (furthestNeighbour != current.y) {
                queue.add(new Point(current.x, furthestNeighbour, current.distance + 1));
            }

            // cells to top
            furthestNeighbour = current.x;
            for (int i = current.x; i < n; i++) {
                if (grid.get(i).charAt(current.y) != 'X') {
                    if (!visited.contains(i + "" + current.y)) {
                        furthestNeighbour = i;
                    }
                } else {
                    break;
                }
            }

            if (furthestNeighbour != current.x) {
                queue.add(new Point(furthestNeighbour, current.y, current.distance + 1));
            }

            // cells to bottom
            furthestNeighbour = current.x;
            for (int i = current.x; i >= 0; i--) {
                if (grid.get(i).charAt(current.y) != 'X') {
                    if (!visited.contains(i + "" + current.y)) {
                        furthestNeighbour = i;
                    }
                } else {
                    break;
                }
            }

            if (furthestNeighbour != current.x) {
                queue.add(new Point(furthestNeighbour, current.y, current.distance + 1));
            }

        }

        return -1;
    }

}

// https://www.hackerrank.com/challenges/castle-on-the-grid/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String gridItem = bufferedReader.readLine();
            grid.add(gridItem);
        }

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
