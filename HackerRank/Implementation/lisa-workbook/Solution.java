import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // https://www.hackerrank.com/challenges/lisa-workbook
    public static int specialProblems(int chapters, int problemsPerPage, int[] numProblems) {
        int count = 0;
        int page = 1;
        int firstProblem, endProblem;
        
        for (int i = 0; i < chapters; i++) {
            int problems = numProblems[i];
            endProblem = 0;
            firstProblem = 1;
            while (problems > 0) {
                if (problems >= problemsPerPage)
                    endProblem += problemsPerPage;
                else
                    endProblem += problems;
                problems -= problemsPerPage;
                if (firstProblem <= page && page <= endProblem)
                    count++;
                firstProblem += problemsPerPage;
                page++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int chapters = sc.nextInt();
        int problemsPerPage = sc.nextInt();
        
        int[] numProblems = new int[chapters];
        
        for (int i = 0; i < chapters; i++)
            numProblems[i] = sc.nextInt();
        
        System.out.println(specialProblems(chapters, problemsPerPage, numProblems));
        
    }
}