/*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
// https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail
int GetNode(Node head, int n) {
     // This is a "method-only" submission. 
     // You only need to complete this method. 
    Stack<Node> stack = new Stack<Node>();
    
    while (head != null) {
        stack.push(head);
        head = head.next;
    }
    
    while (n > 0) {
        stack.pop();
        n--;
    }
    
    return stack.peek().data;
        
}
