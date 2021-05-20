import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

// https://www.hackerrank.com/challenges/java-regex/problem
class MyRegex {
    public static String patternBlock = "([0-1]?[0-9]?[0-9]?|2([0-4][0-9]|5[0-5]))";
    public static String pattern = patternBlock + "\\." + patternBlock + "\\." + patternBlock + "\\." + patternBlock;
}
