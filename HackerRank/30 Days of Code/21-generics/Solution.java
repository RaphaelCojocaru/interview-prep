    /**
    *    Method Name: printArray
    *    Print each element of the generic array on a new line. Do not return anything.
    *    @param A generic array
    **/
    // https://www.hackerrank.com/challenges/30-generics
    // Write your code here
    public <T> void printArray(T[] array) {
        for (T value : array) {
            System.out.println(value);
        }
    }