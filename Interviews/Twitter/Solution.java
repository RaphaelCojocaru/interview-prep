package Twitter;

import java.util.ArrayList;

public class Solution {
	
    static String findNumber(int[] arr, int k) {
        for (int value : arr)
            if (value == k)
                return "YES";
        
        return "NO";
    }
	
    static int[] oddNumbers(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++)
            if (i % 2 == 1)
                list.add(i);
       
        int[] arrInt = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++)
            arrInt[i] = list.get(i);
        
        return arrInt;
    }
    
	
	public static void main(String[] arg) {

	}
}