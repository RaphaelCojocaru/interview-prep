    /*
      Delete Node at a given position in a linked list
      head pointer input could be NULL as well for empty list
      Node is defined as
      class Node {
         int Data;
         Node Next;
      }
    */

    // This is a "method-only" submission.
    // You only need to complete this method.
// https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list
public static Node Delete(Node head, int position) {
    Node list = head;
        
    if (position == 0)
        return head.Next;
        
    position--;
    for (; position > 0 && head != null; head = head.Next, position--);
        
    if (head != null)
        head.Next = head.Next.Next;
        
    return list;
}
