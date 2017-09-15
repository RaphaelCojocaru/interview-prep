// Find max diff in array - double elements (stock prices) > 0.

public double maxDifference(double[] array) throws IllegalArgumentException {
	if (array == null || array.length < 2)
		throw new IllegalArgumentException();
	
	int n = array.length;

	Arrays.sort(array);

	if (array[0] < 0)
		throw new IllegalArgumentException();		
	
	return (array[n - 1] - array[0]);
}
