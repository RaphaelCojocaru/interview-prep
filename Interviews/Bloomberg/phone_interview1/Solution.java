package phone_interview1;

import java.util.LinkedList;

//input: LinkedList [0.2, 4.0, 4.5, 5.6, 8.1]
//output: the mean (average) value after removing the min and max values
public class Solution {
	public static Double libor(LinkedList<Double> list) throws IllegalArgumentException {
		Double sum = 0.0;
		Double min = Double.MAX_VALUE;
		Double max = Double.MIN_VALUE;

		if (list == null || list.size() < 3)
			throw new IllegalArgumentException("The list should have at least 3 elements!");

		// using an Iterator
		Iterator<Double> it = list.iterator();
		while (it.hasNext() == true) {
			double value = it.next();
			if (value < min)
				min = value;
			if (value > max)
				max = value;
			sum += value;
		}
		
		// using an enhacend for-loop
		/*
		for (Double value : list) {
			if (value < min)
				min = value;
			if (value > max)
				max = value;
			sum += value;
		}
		*/
		sum -= min;
		sum -= max;

		sum /= list.size() - 2;

		return sum;
	}

	public static void main(String[] arg) {
		LinkedList<Double> list = new LinkedList<Double>();
		list.addLast(0.2);
		list.addLast(4.5);
		list.addLast(5.0);
		list.addLast(5.5);
		list.addLast(8.1);
		
		Double mean = libor(list);
		System.out.println(mean);
	}
}