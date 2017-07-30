/*
Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
// https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list
Node RemoveDuplicates(Node head) {
    // This is a "method-only" submission. 
    // You only need to complete this method. 
    Node prev = head, list = head;
    
    if (head == null)
        return head;
    
    head = head.next;
    for (; head != null; prev = head, head = head.next) {
        while (head != null && prev.data == head.data)
              head = head.next;
        
        prev.next = head;
        
        if (head == null)
            break;
    }
    
    return list;
}
