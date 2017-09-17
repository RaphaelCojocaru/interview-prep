// https://www.hackerrank.com/challenges/simple-addition-varargs
class Add {
	public void add(int... intArgs) {
		int sum = 0;
		String separator = "";
		
        for (int i : intArgs) {
			sum += i;
			System.out.print(separator + i);
			separator = "+";			
		}
        
		System.out.println("=" + sum);
	}
}