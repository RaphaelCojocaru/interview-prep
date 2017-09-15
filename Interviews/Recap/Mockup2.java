// Return the maximum product of 3 numbers in an array.

public long maxProduct(int[] array) throws IllegalArgumentException {
	if (array == null || array.length < 3)
		throw new IllegalArgumentException();
	
	int n = array.length;

	Arrays.sort(array);
	
	long prodStart = array[0] * array[1];
	long prodEnd = array[n - 2] * array[n - 3];

	if (prodStart > 0 && prodStart > prodEnd)
		return prodStart * array[n - 1];

	return prodEnd * array[n - 1];
}

