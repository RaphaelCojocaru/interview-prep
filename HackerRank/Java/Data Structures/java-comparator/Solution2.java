import java.util.*;

// Write your Checker class here
class Checker implements Comparator<Player> {
    public int compare(Player first, Player second) {
        if (first.score == second.score) {
            return first.name.compareTo(second.name);
        }

        return second.score - first.score;
    }
}

// https://www.hackerrank.com/challenges/java-comparator/problem
class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
