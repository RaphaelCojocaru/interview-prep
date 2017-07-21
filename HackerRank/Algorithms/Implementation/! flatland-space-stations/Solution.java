import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/flatland-space-stations
public class Solution {
    
    // find the distance to the nearest space station starting
    //from the city given as a parameter
    public static int findDistance(int[] cities, int city) {
        // if the city is already a space station return 0
        if (cities[city] == 1)
            return 0;
        
        int left = city - 1;
        int right = city + 1;
        int distance = 1;
        
        // search for a space station on the left/right side of
        //the array
        while (left >= 0 || right < cities.length) {
            if (left >= 0) {
                if (cities[left] == 1)
                    return distance;
            }
            if (right < cities.length) {
                if (cities[right] == 1)
                    return distance;
            }
            distance++;
            left--;
            right++;
        }
        
        return distance;
    }
    
    public static int maxSpaceDistance(int[] c, int n) {
        int maxDistance = -1;
        int[] cities = new int[n];
        
        // build a new array having 1 if and only if the city
        //is a space station
        for (int city : c)
            cities[city] = 1;
        
        // find the maximum distance to a space station
        for (int i = 0; i < cities.length; i++) {
            int distance = findDistance(cities, i);
            if (distance > maxDistance)
                maxDistance = distance;
        }
        
        return maxDistance;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c[] = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        System.out.println(maxSpaceDistance(c, n));
    }
}
