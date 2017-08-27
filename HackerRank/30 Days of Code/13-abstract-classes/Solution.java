// Declare your class here. Do not use the 'public' access modifier.
// https://www.hackerrank.com/challenges/30-abstract-classes
class MyBook extends Book {
    // Declare the price instance variable
    private int price;    
    /**   
    *   Class Constructor
    *   
    *   @param title The book's title.
    *   @param author The book's author.
    *   @param price The book's price.
    **/
    // Write your constructor here
    public MyBook(String title, String author, int price){
        super(title,author);
        this.price = price;
    }
    
    public void display(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
    /**   
    *   Method Name: display
    *   
    *   Print the title, author, and price in the specified format.
    **/
    // Write your method here
}
// End class