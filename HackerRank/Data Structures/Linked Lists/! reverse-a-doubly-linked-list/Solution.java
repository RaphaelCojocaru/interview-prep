/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
     Node prev;
  }
*/
// https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list
Node Reverse(Node head) {
    Stack<Node> stack = new Stack<Node>();
    
    if (head == null)
        return head;
    
    // put all the nodes into stack
    for (; head != null; head = head.next)
        stack.push(head);
    
    // get the new head of the list from the stack
    Node list = stack.pop();
    // set the prev to null
    list.prev = null;
    // set the tail
    Node tail = list;
    
    while (stack.isEmpty() == false) {
        // get another node from the stack
        Node node = stack.pop();
        
        // update the links        
        tail.next = node;
        node.prev = tail;
        
        tail = node;
    }

    // set the next of the tail to null
    tail.next = null;
    
    return list;
}
