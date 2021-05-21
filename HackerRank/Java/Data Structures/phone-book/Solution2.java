//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

// https://www.hackerrank.com/challenges/phone-book/problem
class Solution2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int noOfEntries = Integer.parseInt(scan.nextLine());

        HashMap<String, Integer> phoneBook = new HashMap<>();
		for (int i = 0; i < noOfEntries; i++) {
			String name = scan.nextLine();
			int phone = Integer.parseInt(scan.nextLine());
            phoneBook.put(name, phone);
		}

		while (scan.hasNext()) {
			String name = scan.nextLine();
            if (phoneBook.containsKey(name)) {
                System.out.println(name + "=" + phoneBook.get(name));
            } else {
                System.out.println("Not found");
            }
		}

        scan.close();
	}
}
