// https://www.hackerrank.com/challenges/java-comparator
// Write your Checker class here
class Checker implements Comparator<Player> {
    public int compare(Player p1, Player p2) {
        // compare the scores
        if (p2.score > p1.score)
            return 1;
        else if (p2.score < p1.score)
            return -1;
        // compare the names
        return p1.name.compareTo(p2.name);
    }
}