/*
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists
int FindMergeNode(Node headA, Node headB) {
    // Complete this function
    // Do not write the main method. 
    
    // Use a stack to iterate in reverse order
    Stack<Node> stackA = new Stack<Node>();
    Stack<Node> stackB = new Stack<Node>();
    
    int mergePoint = -1;
    
    for (; headA != null; headA = headA.next)
        stackA.push(headA);
    
    for (; headB != null; headB = headB.next)
        stackB.push(headB);
    
    while (stackA.isEmpty() == false && stackB.isEmpty() == false) {
        Node nodeA = stackA.pop();
        Node nodeB = stackB.pop();
        
        // update the mergePoint
        if (nodeA.data == nodeB.data)
            mergePoint = nodeA.data;
        else
            break;
    }
        
    return mergePoint;
}
