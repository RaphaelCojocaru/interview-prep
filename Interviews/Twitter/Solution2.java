package Twitter;

import java.io.*;
import java.util.*;

public class Solution2 {
	// class for engagement
	static class Engagement {
		private String type;
		private int number;
		private int year, month, day;

		public Engagement(int year, int month, int day, String type, int number) {
			this.setYear(year);
			this.setMonth(month);
			this.setDay(day);
			this.type = type;
			this.number = number;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}
	}

	// class for data
	static class Data {
		private int year, month;
		// list for storing the engagements
		private ArrayList<Engagement> engagements;

		public Data(int year, int month, int day, String engagementType, int engagementNo) {
			this.year = year;
			this.month = month;
			this.engagements = new ArrayList<Engagement>();
			this.engagements.add(new Engagement(year, month, day, engagementType, engagementNo));
		}

		// equals override for the contains method used later
		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (obj == this)
				return true;
			if (obj instanceof Data == false)
				return false;

			Data data = (Data) obj;

			if (this.year == data.year && this.month == data.month)
				return true;

			return false;
		}

	}

	// comparator for sorting the data in decreasing order by time
	static class DataComparator implements Comparator<Data> {
		@Override
		public int compare(Data data1, Data data2) {
			return compareDates(data1.year, data1.month, data2.year, data2.month);
		}
	}

	// comparator for sorting the engagements in alphabetical order
	static class EngagementComparator implements Comparator<Engagement> {
		@Override
		public int compare(Engagement e1, Engagement e2) {
			return e1.type.compareTo(e2.type);
		}
	}

	public static int compareDates(int year1, int month1, int year2, int month2) {
		if (year1 > year2)
			return -1;
		else if (year1 < year2)
			return 1;

		if (month1 > month2)
			return -1;
		else if (month1 < month2)
			return 1;

		return 0;
	}

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// get the interval dates
		String line = br.readLine();
		String[] parts = line.split(", ");
		int startYear = Integer.parseInt(parts[0].split("-")[0]);
		int startMonth = Integer.parseInt(parts[0].split("-")[1]);
		int endYear = Integer.parseInt(parts[1].split("-")[0]);
		int endMonth = Integer.parseInt(parts[1].split("-")[1]);

		// create a list of Data
		ArrayList<Data> list = new ArrayList<Data>();

		// read the empty line
		br.readLine();

		line = br.readLine();
		while (line != null && line.length() > 0) {
			// parse the line
			parts = line.split(", ");
			int year = Integer.parseInt(parts[0].split("-")[0]);
			int month = Integer.parseInt(parts[0].split("-")[1]);
			int day = Integer.parseInt(parts[0].split("-")[2]);
			String type = parts[1];
			int no = Integer.parseInt(parts[2]);

			// check for the date to be within the intervale given
			if (compareDates(startYear, startMonth, year, month) >= 0
					&& compareDates(endYear, endMonth, year, month) < 0) {
				// create a new Data object
				Data data = new Data(year, month, day, type, no);

				// check if it already inside the list
				if (list.contains(data)) {
					// if so, then check if we already have an engagement of that certain type
					// and update the number of events
					int index = list.indexOf(data);
					boolean found = false;
					for (Engagement e : list.get(index).engagements)
						if (e.type.equals(type) == true) {
							found = true;
							e.number += no;
						}

					// if the engagement was not found, then add in into engagements list of
					// current Data
					if (found == false)
						list.get(index).engagements.add(new Engagement(year, month, day, type, no));
				} else { // if Data is not part of the list, then add it
					list.add(data);
				}
			}

			// read the next line
			line = br.readLine();
		}

		// sort the Data list by time
		Collections.sort(list, new Solution2.DataComparator());

		// for each Data within list
		for (Data data : list) {
			// print the time
			if (data.month > 9)
				System.out.print(data.year + "-" + data.month);
			else
				System.out.print(data.year + "-0" + data.month);

			// sort the engagements in aphabetical order by type
			Collections.sort(data.engagements, new Solution2.EngagementComparator());

			// print the engagement type and number
			for (Engagement e : data.engagements)
				System.out.print(", " + e.type + ", " + e.number);
			System.out.println();
		}

		// AUX
		String s = "ana, are";
		String[] parts2 = s.split(", ");
		System.out.println(parts2[0] + " " + parts2[1]);

		String ss = "2015-07";
		System.out.println(Integer.parseInt(ss.split("-")[0]) + ":" + Integer.parseInt(ss.split("-")[1]));

		String rs = "124 12 21 2";
		System.out.println(rs.split(" ")[0]);
	}
}