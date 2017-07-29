/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
Node mergeLists(Node headA, Node headB) {
     // This is a "method-only" submission. 
     // You only need to complete this method 
    Node head = null, tail = null;
        
    while (headA != null && headB != null) {
        if (headA.data < headB.data) {
            if (head == null)
                head = headA;
            else
                tail.next = headA;
            
            tail = headA;
            
            headA = headA.next;
        } else {
            if (head == null)
                head = headB;
            else
                tail.next = headB;
            
            tail = headB;
            
            headB = headB.next;
        }
    }
    
    for (; headA != null; headA = headA.next) {
        if (head == null)
            head = headA;
        else
            tail.next = headA;
        
        tail = headA;
    }
    
    for (; headB != null; headB = headB.next) {
        if (head == null)
            head = headB;
        else
            tail.next = headB;
        
        tail = headB;
    }
    
    tail.next = null;
        
    return head;
}
