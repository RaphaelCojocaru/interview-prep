// https://www.hackerrank.com/challenges/java-hashset
HashSet<String> set = new HashSet<String>();
//Write your code here
for (int i = 0; i < pair_left.length; i++) {
	set.add((pair_left[i] + " " + pair_right[i]));
	System.out.println(set.size());
}