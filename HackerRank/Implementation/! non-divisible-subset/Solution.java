import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/non-divisible-subset
public class Solution {

    // solve it again with a simple array
    public static int maxSubset(int n, int[] arr, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        Set<Integer> set = new HashSet<Integer>();
        int count = 0;
        
        // we count the occurrences of each remainder of division
        for (int value : arr) {
            int key = value % k;
            if (hash.containsKey(key))
                hash.put(key, hash.get(key) + 1);
            else
                hash.put(key, 1);
        }

        // for each remainder X we need to decide what we choose: X or its complement (k - X)
        // i.e. for k = 5 we have 2 and 3, or maybe 1 and 4
        for (Map.Entry entry : hash.entrySet()) {
            int key = (int)entry.getKey();
            // for values having remainder 0 we need to take it only one of them
            // same if key is even and we have its halfs: 4 - 2, 2
            if (key == 0 || key * 2 == k) {
                count++;
                continue;
            }
            
            // we mark the values we used by adding them in a set
            if (set.contains(key) == false) {
                int complement = k - key;
                if (hash.containsKey(complement))
                    count += Math.max((int)entry.getValue(), hash.get(complement));
                else
                    count += (int)entry.getValue();
                set.add(complement);
            } 
        }
        
        return count;
    }
    
    public static int maxSubset_orig(int n, int[] arr, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        Set<Integer> set = new HashSet<Integer>();
        int count = 0;
        for (int value : arr) {
            int key = value % k;
            if (hash.containsKey(key) && key != 0 &&  k != 2 * key)
                hash.put(key, hash.get(key) + 1);
            else
                hash.put(key, 1);
        }
        /*
        for (Map.Entry entry : hash.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        */
        for (Map.Entry entry : hash.entrySet()) {
            if (set.contains(k - (int)entry.getKey()) == false) {
                set.add((int)entry.getKey());
                count += (int)entry.getValue();
            } else {
                if (hash.get(k - (int)entry.getKey()) < (int)entry.getValue()) {
                    set.remove(k - (int)entry.getKey());
                    set.add((int)entry.getKey());
                    count -= hash.get(k - (int)entry.getKey());
                    count += (int)entry.getValue();
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(maxSubset(n, arr, k));
        
    }
}