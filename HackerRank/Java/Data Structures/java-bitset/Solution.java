import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-bitset/problem
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bitsetLength = scan.nextInt();
        int numberOfOperations = scan.nextInt();

        scan.nextLine();

        BitSet firstSet = new BitSet(bitsetLength);
        BitSet secondSet = new BitSet(bitsetLength);

        for (int i = 0; i < numberOfOperations; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split("[\\s]+");

            switch(tokens[0]) {
                case "AND": {
                    if (Integer.parseInt(tokens[1]) == 1) {
                        firstSet.and(secondSet);
                    } else {
                        secondSet.and(firstSet);
                    }

                    break;
                }
                case "OR": {
                    if (Integer.parseInt(tokens[1]) == 1) {
                        firstSet.or(secondSet);
                    } else {
                        secondSet.or(firstSet);
                    }

                    break;
                }
                case "XOR": {
                    if (Integer.parseInt(tokens[1]) == 1) {
                        firstSet.xor(secondSet);
                    } else {
                        secondSet.xor(firstSet);
                    }

                    break;
                }
                case "FLIP": {
                    int index = Integer.parseInt(tokens[2]);
                    if (Integer.parseInt(tokens[1]) == 1) {
                        firstSet.flip(index);
                    } else {
                        secondSet.flip(index);
                    }

                    break;
                }
                case "SET": {
                    int index = Integer.parseInt(tokens[2]);
                    if (Integer.parseInt(tokens[1]) == 1) {
                        firstSet.set(index);
                    } else {
                        secondSet.set(index);
                    }

                    break;
                }
            }

            System.out.println(firstSet.cardinality() + " " + secondSet.cardinality());
        }

        scan.close();
    }
}
