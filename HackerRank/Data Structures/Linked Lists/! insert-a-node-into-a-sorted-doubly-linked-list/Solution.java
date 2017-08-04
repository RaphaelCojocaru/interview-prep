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
// https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list
Node SortedInsert(Node head, int data) {
    Node list = head, prev = null;
    
    // find the first node having data bigger than parameter
    for (; head != null; prev = head, head = head.next)
        if (head.data > data)
            break;
    
    // create the node
    Node aux = new Node();
    aux.data = data;
    
    // if prev is null, then insert at head of the list
    if (prev == null) {
        aux.next = head;
        head.prev = aux;
        return aux;
    }
        
    // update the links
    aux.next = head;
    aux.prev = prev;
    prev.next = aux;
    // if head is not null, set the prev
    if (head != null)
        head.prev = aux;
    // else we insert at the end of the list
    
    return list;
}
