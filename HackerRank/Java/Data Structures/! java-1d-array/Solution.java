import java.util.*;

// https://www.hackerrank.com/challenges/java-1d-array
public class Solution {
    public static boolean canWin(int leap, int[] game, int pos) {
        // check for game state
        if (pos < 0 || game[pos] == 1)
            return false;
        if (pos + 1 >= game.length || pos + leap >= game.length)
            return true;
        
        // mark the current position as visited
        game[pos] = 1;
        
        // try the other possible positions
        return canWin(leap, game, pos + 1) || canWin(leap, game, pos + leap) || canWin(leap, game, pos - 1);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
