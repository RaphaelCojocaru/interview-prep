public class Solution {
        // https://www.hackerrank.com/challenges/30-data-types
        public static void main(String[] args) {
                int i = 4;
                double d = 4.0;
                String s = "HackerRank ";
                Scanner scan = new Scanner(System.in);
                /* Declare second integer, double, and String variables. */
                int v1;
                double v2;
                String v3;
                /* Read and save an integer, double, and String to your variables.*/
                // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
                String line = scan.nextLine();
                v1 = Integer.parseInt(line);
                line = scan.nextLine();
                v2 = Double.parseDouble(line);
                v3 = scan.nextLine();
                /* Print the sum of both integer variables on a new line. */
                System.out.println(v1 + i);
                /* Print the sum of the double variables on a new line. */
        	System.out.println(v2 + d);
                /* Concatenate and print the String variables on a new line; 
                the 's' variable above should be printed first. */
                System.out.println(s + v3);
        }
}