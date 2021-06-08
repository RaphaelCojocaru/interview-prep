import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        long[] containersCapacity = new long[container.size()];
        long[] ballsOfType = new long[container.size()];
        HashSet<Integer> containerFull = new HashSet<>();

        // count each container capacity & the number of balls for each type
        for (int i = 0; i < container.size(); i++) {
            for (int j = 0; j < container.size(); j++) {
                containersCapacity[i] += container.get(i).get(j);
                ballsOfType[j] += container.get(i).get(j);
            }
        }

        // Version #1 - match balls of type 0 to container 0
        boolean foundMatch;
        // check if number of balls of specific type can match its container capacity
        for (int i = 0; i < container.size(); i++) {
            foundMatch = false;
            for (int j = 0; j < container.size(); j++) {
                if (containerFull.contains(j)) {
                    continue;
                }

                if (ballsOfType[i] == containersCapacity[j]) {
                    containerFull.add(j);

                    foundMatch = true;

                    break;
                }
            }

            if (!foundMatch) {
                return "Impossible";
            }
        }

        return "Possible";

        // Version #2 - the matching order does not matter
        Arrays.sort(containersCapacity);
        Arrays.sort(ballsOfType);

        for (int i = 0; i < containersCapacity.length; i++) {
            if (containersCapacity[i] != ballsOfType[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }

}

// https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> container = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] containerRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> containerRowItems = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowTempItems[j]);
                    containerRowItems.add(containerItem);
                }

                container.add(containerRowItems);
            }

            String result = Result.organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
