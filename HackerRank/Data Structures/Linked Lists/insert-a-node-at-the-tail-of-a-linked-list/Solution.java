/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
// https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
Node Insert(Node head,int data) {
// This is a "method-only" submission. 
// You only need to complete this method. 
    Node prev = null, list = head, aux;
    
    aux = new Node();
    aux.data = data;
    
    for (; head != null; prev = head, head = head.next);
    
    if (prev != null) {
        prev.next = aux;
        return list;
    }
        
    return aux;
}
