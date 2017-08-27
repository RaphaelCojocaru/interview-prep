// https://www.hackerrank.com/challenges/30-inheritance
class Student extends Person{
	private int[] testScores;

    /*	
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    // Write your constructor here
    public Student(String firstName, String lastName, int id, int[] scores) {
        super(firstName, lastName, id);
        this.testScores = scores;
    }
    /*	
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    // Write your method here
    public char calculate() {
        int sum = 0;
        for (int score : testScores)
            sum += score;
        sum /= testScores.length;
        
        if (sum >= 90)
            return 'O';
        else if (sum >= 80)
            return 'E';
        else if (sum >= 70)
            return 'A';
        else if (sum >= 55)
            return 'P';
        else if (sum >= 40)
            return 'D';
        else
            return 'T';
          
    }
}