import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */
    public static List<Integer> acmTeam(List<String> topic) {
        int max = -1, noOfMaxs = -1, differentTopics;

        BitSet set1 = new BitSet(topic.get(0).length());
        BitSet set2 = new BitSet(topic.get(0).length());

        for (int i = 0; i < topic.size() - 1; i++) {
            for (int j = i + 1; j < topic.size(); j++) {
                set1.clear();
                set2.clear();

                stringToBitset(topic.get(i), set1);
                stringToBitset(topic.get(j), set2);

                set1.or(set2);

                differentTopics = set1.cardinality();

                if (differentTopics > max) {
                    max = differentTopics;

                    noOfMaxs = 1;
                } else if (differentTopics == max) {
                    noOfMaxs++;
                }
            }
        }

        return new ArrayList<Integer>(Arrays.asList(max, noOfMaxs));
    }

    public static void stringToBitset(String s, BitSet set) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                set.set(i);
            }
        }
    }

     public static List<Integer> acmTeam2(List<String> topic) {
        int max = -1, noOfMaxs = -1, differentTopics;

        for (int i = 0; i < topic.size() - 1; i++) {
            for (int j = i + 1; j < topic.size(); j++) {
                differentTopics = differentTopics(topic.get(i), topic.get(j));

                if (differentTopics > max) {
                    max = differentTopics;

                    noOfMaxs = 1;
                } else if (differentTopics == max) {
                    noOfMaxs++;
                }
            }
        }

        return new ArrayList<Integer>(Arrays.asList(max, noOfMaxs));
    }

    public static int differentTopics(String s1, String s2) {
        int total = 0, first, second;

        for (int i = 0; i < s1.length(); i++) {
            first = Character.getNumericValue(s1.charAt(i));
            second = Character.getNumericValue(s2.charAt(i));

            if (first + second > 0) {
                total++;
            }
        }

        return total;
    }

}

// https://www.hackerrank.com/challenges/acm-icpc-team/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String topicItem = bufferedReader.readLine();
            topic.add(topicItem);
        }

        List<Integer> result = Result.acmTeam(topic);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
