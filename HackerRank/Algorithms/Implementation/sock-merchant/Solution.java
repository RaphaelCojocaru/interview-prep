import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int count = count(c);
        System.out.println(count);
    }
    
    public static int count(int[] c){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<c.length;i++){
            if(map.containsKey(c[i]))
                map.put(c[i], map.get(c[i]) + 1);
            else
                map.put(c[i], 1);
        }
        
        // FOR ME:
        for (Integer key : map.keySet()) {
        }
        for (Integer value : map.values()) {
        }
        // FOR ME 
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            count += value/2;
        }
        return count;
    }
}
