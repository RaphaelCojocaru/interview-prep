//Write your code here
// https://www.hackerrank.com/challenges/30-more-exceptions
class Calculator {
    
    public int power(int n, int p) throws IllegalArgumentException {
        if (n < 0 || p < 0)
            throw new IllegalArgumentException("n and p should be non-negative");
        
        return (int) Math.pow(n, p);   
    }
}