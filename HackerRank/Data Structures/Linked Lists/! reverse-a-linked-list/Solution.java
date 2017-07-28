/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as  
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 
// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
Node Reverse(Node list) {
    Stack<Node> stack = new Stack<Node>();
    Node head = null, tail = null;
    
    for (; list != null; list = list.next)
        stack.push(list);
    
    while (stack.empty() == false) {
        Node currNode = stack.pop();
        
        if (head == null)
            head = currNode;
        else
            tail.next = currNode;
        
        tail = currNode;
    }
    
    tail.next = null;
    
    return head;
}
