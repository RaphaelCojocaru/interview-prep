package Big_O;

public class Fibonacci {
	public static void allFib(int range) {
		for (int i = 0; i <= range; i++) {
			System.out.println(fib(i));
		}
	}
	
	public static int fib(int n) {
		if (n <= 0) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		return fib(n - 1) + fib(n - 2);
	}
	


	public static void allFibMemo(int range) {
		int[] memo = new int[range + 2];
		
		for (int i = 0; i <= range; i++) {
			System.out.println(fibMemo(i, memo));
		}
	}
	
	public static int fibMemo(int n, int[] memo) {
		if (n <= 0) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		if (memo[n] > 0) {
			return memo[n];
		}
		
		memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
		
		return memo[n];
	}
	
	
	public static void main(String[] args) {
		int n = 43;
		
		long startTime = System.currentTimeMillis();
		
		allFib(n);
		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		
		System.out.println("_________________");
		
		System.out.println(elapsedTime + "ms");
		
		
		startTime = System.currentTimeMillis();
		
		allFibMemo(n);
		
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		
		System.out.println("_________________");
		
		System.out.println(elapsedTime + "ms");
	}
}
