package Implementation;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/counting-valleys
public class Solution {

    public static int solveIt(String path) {
        int level = 0, valleysNo = 0;
        boolean valley = false;
        
        if (path == null)
            return 0;
        
        for (char c : path.toCharArray())
            if (c == 'U') {
                level++;
                if (valley == true && level == 0) {
                    valleysNo++;
                    valley = false;
                }
            } else if (c == 'D') {
                level--;
                if (level < 0 && valley == false)
                    valley = true;
            }
        
        return valleysNo;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        sc.next();
        System.out.println(solveIt(sc.next()));
        System.out.println("==============");
        int j;
        for ( j = 4;j<10;j++)
        	break;
        System.out.println(j);
    }
}