import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/designer-pdf-viewer
public class Solution {
	
    public static int getArea(String word, int[] h){
        if(word == null)
            return 0;
        int max_height = 0;
        int width = word.length();
        
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(h[index] > max_height)
                max_height = h[index];
        }
        
        return (max_height * width);
    }
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i=0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        
        int area = getArea(word, h);
        System.out.println(area);
    }
}
