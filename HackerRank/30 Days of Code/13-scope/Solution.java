	// Add your code here
    // https://www.hackerrank.com/challenges/30-scope
    public Difference(int[] array) {
        elements = array;
    }

    public void computeDifference() {
        int[] copy = Arrays.copyOf(elements, elements.length);
        Arrays.sort(copy);
        maximumDifference = Math.abs(copy[copy.length - 1] - copy[0]);
    }
