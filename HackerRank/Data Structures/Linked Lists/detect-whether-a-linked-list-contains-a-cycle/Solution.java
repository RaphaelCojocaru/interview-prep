/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

// https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
boolean hasCycle(Node head) {
    // store the nodes inside an ArrayList called "visited"
    ArrayList<Node> visited = new ArrayList<Node>();   
    for (; head != null; head = head.next)
        if (visited.contains(head) == true)
            return true;
        else
            visited.add(head);
    
    return false;
}
