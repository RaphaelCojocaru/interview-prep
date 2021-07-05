import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        int[] visited = new int[n + 1];
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int noOfRoads;
        long cost = 0;

        if (c_lib <= c_road) {
            return c_lib * (long) n;
        }

        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for (List<Integer> road : cities) {
            int start = road.get(0);
            int end = road.get(1);

            edges.get(start).add(end);
            edges.get(end).add(start);
        }

        // PERFORM BFS
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                cost += c_lib;

                visited[i] = 1;

                noOfRoads = 0;

                for (int neighbour : edges.get(i)) {
                    if (visited[neighbour] == 0) {
                        queue.add(neighbour);

                        visited[neighbour] = 1;

                        noOfRoads++;
                    }
                }

                while (!queue.isEmpty()) {
                    int neighbour = queue.remove();

                    for (int nb : edges.get(neighbour)) {
                        if (visited[nb] == 0) {
                            queue.add(nb);

                            visited[nb] = 1;

                            noOfRoads++;
                        }
                    }
                }

                cost += c_road * noOfRoads;
            }
        }

        return cost;
    }
}

// https://www.hackerrank.com/challenges/torque-and-development/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int c_lib = Integer.parseInt(firstMultipleInput[2]);

            int c_road = Integer.parseInt(firstMultipleInput[3]);

            List<List<Integer>> cities = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] citiesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> citiesRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowTempItems[j]);
                    citiesRowItems.add(citiesItem);
                }

                cities.add(citiesRowItems);
            }

            long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
