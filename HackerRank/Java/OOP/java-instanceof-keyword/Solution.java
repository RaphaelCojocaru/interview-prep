import java.util.*;

class Student {}
class Rockstar {}
class Hacker {}

// https://www.hackerrank.com/challenges/java-instanceof-keyword/problem
public class InstanceOFTutorial {
    public static String count(Array List mylist) {
        int noOfStudents = 0, noOfRockstars = 0, noOfHackers = 0;
          
        for (int i = 0; i < mylist.size(); i++) {
            Object element = mylist.get(i);
            if (element instanceof Hacker) {
                noOfHackers++;
                continue;
            }
            
            if (element instanceof Rockstar) {
                noOfRockstars++;
                continue;
            }
            
            if (element instanceof Student) {
                noOfStudents++;
                continue;
            }
        }
           
        return Integer.toString(noOfStudents) + " " + Integer.toString(noOfRockstars) + " " + Integer.toString(noOfHackers);
    }
    
    public static void main(String []args) {
        ArrayList mylist = new ArrayList();
        Scanner scan = new Scanner(System.in);
        
        int noOfKids = scan.nextInt();
        for (int i = 0; i < noOfKids; i++){
            String type = scan.next();
            if (type.equals("Student")) {
                mylist.add(new Student());
            }
            if (type.equals("Rockstar")) {
                mylist.add(new Rockstar());
            }
            if (type.equals("Hacker")) {
                mylist.add(new Hacker());
            }
        }
        
        System.out.println(count(mylist));
    }
}
