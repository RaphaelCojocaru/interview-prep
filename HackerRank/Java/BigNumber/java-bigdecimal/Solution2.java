import java.math.BigDecimal;
import java.util.*;

// https://www.hackerrank.com/challenges/java-bigdecimal/problem
class Solution2 {
    public static void main(String []args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] s = new String[n+2];
        for (int i = 0; i < n; i++){
            s[i] = sc.next();
        }

        sc.close();

        //Perform bubble sort
        boolean swapped;
        BigDecimal value1, value2;
        String temp;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                value1 = new BigDecimal(s[j]);
                value2 = new BigDecimal(s[j + 1]);
                
                if (value1.compareTo(value2) < 0) {
                    temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                    
                    swapped = true;
                } 
            }
            
            if (!swapped) {
                break;
            }
        }

        //Output
        for (int i = 0; i < n; i++)
        {
            System.out.println(s[i]);
        }
    }
}