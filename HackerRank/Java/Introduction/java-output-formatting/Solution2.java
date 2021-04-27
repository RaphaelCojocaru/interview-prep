import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-output-formatting/problem
public class Solution2 {
    public static void printBeautifully(String string, int integer) {
        System.out.print(string);

        for (int i = 0; i < 15 - string.length(); i++) {
            System.out.print(" ");
        }

        if (integer < 10) {
            System.out.print("00");
        } else if (integer < 100) {
            System.out.print("0");
        }

        System.out.println(integer);

        // System.out.printf("%-15s%03d%n", string, integer);
    }

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("================================");

            for (int i = 0; i < 3; i++) {
                String string = scanner.next();
                int integer = scanner.nextInt();

                printBeautifully(string, integer);
            }

            System.out.println("================================");
    }
}




