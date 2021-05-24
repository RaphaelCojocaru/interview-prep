import java.util.*;

// https://www.hackerrank.com/challenges/java-sort/problem
class StudentComparator implements Comparator<Student> {
    public int compare(Student first, Student second) {
        if (first.getCgpa() == second.getCgpa()) {
            if (first.getFname().equals(second.getFname())) {
                return first.getId() - second.getId();
            } else {
                return first.getFname().compareTo(second.getFname());
            }
        }

        return first.getCgpa() < second.getCgpa() ? 1 : -1;
    }
}

class Student {
	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

//Complete the code
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

        Collections.sort(studentList, new StudentComparator());

        for (Student st : studentList) {
			System.out.println(st.getFname());
		}

        in.close();
	}
}
