/*
  Insert Node at a given position in a linked list 
  head can be NULL 
  First element in the linked list is at position 0
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
Node InsertNth(Node head, int data, int position) {
    // This is a "method-only" submission. 
    // You only need to complete this method. 
    Node aux = new Node();
    aux.data = data;
    
    // insert at the beginning
    if (position == 0) {
        aux.next = head;
        return aux;
    }
    
    // store the original head of the list for return
    Node list = head, prev = null;
    
    /*
    // position is indexed starting _before_ the first element
    for (; position > 0 && head != null; prev = head, head = head.next, position--);
    
    if (prev == null)
        return list;
    
    prev.next = aux;
    aux.next = head;
    */
    
    // position is indexed starting _after_ the first element
    position--;
    for (; position > 0 && head != null; head = head.next, position--);
    
    if (head == null)
        return list;
    
    aux.next = head.next;
    head.next = aux;
    
    return list;
}
