import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// // https://www.hackerrank.com/challenges/simple-addition-varargs/problem
class Add {
    public void add(int n1, int n2, int ... numbers) {
        int sum = n1 + n2;

        System.out.print(n1 + "+" + n2);

        for (int number : numbers) {
            System.out.print("+" + number);

            sum += number;
        }

        System.out.println("=" + sum);
    }
}

public class Solution {
    public static void main(String[] args) {
       try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		    int n1 = Integer.parseInt(br.readLine());
		    int n2 = Integer.parseInt(br.readLine());
			int n3 = Integer.parseInt(br.readLine());
			int n4 = Integer.parseInt(br.readLine());
			int n5 = Integer.parseInt(br.readLine());
			int n6 = Integer.parseInt(br.readLine());

			Add adder = new Add();
			adder.add(n1,n2);
			adder.add(n1,n2,n3);
			adder.add(n1,n2,n3,n4,n5);
			adder.add(n1,n2,n3,n4,n5,n6);

			Method[] methods = Add.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload = false;

			for (int i = 0; i < methods.length; i++) {
				if(set.contains(methods[i].getName())) {
				    overload=true;
					break;
				}

				set.add(methods[i].getName());
			}

			if (overload) {
				throw new Exception("Overloading not allowed");
			}
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
