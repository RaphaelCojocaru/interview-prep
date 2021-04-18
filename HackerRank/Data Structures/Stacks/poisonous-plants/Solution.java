import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'poisonousPlants' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static int poisonousPlants(List<Integer> p) {
        int noOfDays = 0;
        ArrayList<Integer> copy = new ArrayList<>();

        while (true) {
            copy.clear();

            copy.add(p.get(0));

            for (int i = 1; i < p.size(); i++) {
                if (p.get(i) <= p.get(i - 1)) {
                    copy.add(p.get(i));
                }
            }

            if (copy.size() == p.size()) {
                break;
            }

            p.clear();
            for (int value : copy) {
                p.add(value);
            }

            noOfDays++;

            for (int value : p) {
                System.out.print(value + " ");
            }

            System.out.println();
        }


        return noOfDays;
    }

}

// https://www.hackerrank.com/challenges/poisonous-plants
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] pTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> p = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pTemp[i]);
            p.add(pItem);
        }

        int result = Result.poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
