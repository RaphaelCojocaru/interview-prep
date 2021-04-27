import java.util.*;
import java.io.*;
import java.lang.*;

class Solution2 {
    public static void computeAndPrintSeries(int a, int b, int n) {
        StringBuilder sb = new StringBuilder();

        int start = a + b;

        sb.append(start + " ");

        for (int i = 1; i < n; i++) {
            start += Math.pow(2, i) * b;

            sb.append(start + " ");
        }

        System.out.println(sb.toString());
    }

    public static void main(String []argh){
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int i = 0; i < queries; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();

            computeAndPrintSeries(a, b, n);
        }

        scanner.close();
    }
}
