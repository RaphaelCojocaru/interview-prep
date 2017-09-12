// https://www.hackerrank.com/challenges/java-generics
class Printer {
    //Write your code here
    public <T> void printArray(T[] arr) {
        for (T elem : arr)
            System.out.println(elem);
    }
}
