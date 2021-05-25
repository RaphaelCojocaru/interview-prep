import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

// https://www.hackerrank.com/challenges/java-priority-queue/problem

/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCGPA() {
        return this.cgpa;
    }

    public int compareTo(Student other) {
        if (this.cgpa == other.cgpa) {
            if (this.name.equals(other.name)) {
                return this.id - other.id;
            } else {
                return this.name.compareTo(other.name);
            }
        }

        if (this.cgpa > other.cgpa) {
            return -1;
        }

        return 1;
    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        Queue<Student> queue = new PriorityQueue<Student>();
        List<Student> list = new ArrayList<Student>();

        for (String event : events) {
            String[] tokens = event.split("\\s");

            switch (tokens[0]) {
                case "ENTER": {
                    Student newStudent = new Student(Integer.parseInt(tokens[3]), tokens[1], Double.parseDouble(tokens[2]));
                    queue.add(newStudent);
                    break;
                }
                case "SERVED": {
                    if (!queue.isEmpty()) {
                        queue.remove();
                    }
                    break;
                }
            }
        }

        while (!queue.isEmpty()) {
            list.add(queue.remove());
        }

        return list;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
