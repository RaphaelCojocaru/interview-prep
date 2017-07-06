import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/caesar-cipher-1/problem
public class Solution {
    public static String cipherCaesar(String s, int key) {
        char[] arr = s.toCharArray();
        
        // DOES NOT CHANGE the content !!
        for (char ch : arr) {
            if (Character.isLetter(ch)) {
                ch += key;
            }
        }
        
        // 26 characters in English alphabet
        for (int i = 0; i < arr.length; i++)
            if (Character.isLetter(arr[i])) {
                if (Character.isUpperCase(arr[i])) {
                    arr[i] += key % 26;
                    if (arr[i] > 'Z')
                        arr[i] -= 26;
                } else if (Character.isLowerCase(arr[i])) {
                    arr[i] += key % 26;
                    if (arr[i] > 'z')
                        arr[i] -= 26;
                }
            }
                    
    
        return String.valueOf(arr);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        
        System.out.println(cipherCaesar(s, k));
    }
}
