// Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

// https://www.hackerrank.com/challenges/phone-book
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
         String name = in.nextLine();
         int phone = in.nextInt();
         map.put(name, phone);
         in.nextLine();
      }
       
      while (in.hasNext() == true) {
        String s = in.nextLine();
        if (map.containsKey(s) == true) {
            System.out.println(s+"="+map.get(s));
        } else
            System.out.println("Not found");
      }
   }
}
