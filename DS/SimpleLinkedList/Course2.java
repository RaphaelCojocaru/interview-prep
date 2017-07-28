package SimpleLinkedList;

import java.util.Stack;

public class Course2 {
	public static void printList(Node list) {
		for (; list != null; list = list.next)
			System.out.print(list.info + " ");
		System.out.println();
	}
	
	public static Node copyList(Node list) {
		Node head = null, aux, tail = null;
		
		for (; list != null; list = list.next) {
			// create a new node
			aux = new Node(list.info);
			
			// if the head of the copy is null, then set it
			if (head == null)
				head = aux;
			else // link the previous node with the current one
				tail.next = aux;
			
			// update the tail
			tail = aux;
		}
		
		return head;
	}
	
	public static Node moveElements(Node list) {
		Node head = null, tail = null, prev = null;
		
		for (; list != null; prev = list, list = list.next) {
			// move the even elements into a new list
			if (list.info % 2 == 0) {
				// if the head of the copy is null, then set it
				if (head == null)
					head = list;
				else // link the previous node with the current one
					tail.next = list;
			
				// update the tail
				tail = list;
				
				// break the old link
				prev.next = list.next;
			}
		}
		
		// set the link of the last element
		tail.next = null;
		
		return head;
	}
	
	public static Node insertOrdered(Node list, int data) {
		Node head = list, prev = null, aux;
		
		// find the first element bigger, having the previous one stored
		for (; list != null; prev = list, list = list.next) {
			if (list.info > data)
				break;
		}
		
		// create the node
		aux = new Node(data);
		
		// if we need to insert the new node at the head of the list
		if (prev == null) {
			aux.next = list;
			return aux;
		}
		
		// link the nodes
		aux.next = prev.next;
		prev.next = aux;
		
		return head;
	}
	
	public static Node Reverse(Node list) {
	    Stack<Node> stack = new Stack<Node>();
	    Node head = null, tail = null;
	    
	    // put the nodes into the stack
	    for (; list != null; list = list.next)
	        stack.push(list);
	    
	    // reverse the lsit
	    while (stack.empty() == false) {
	    	// get the node from the stack
	        Node currNode = stack.pop();

	        // create the list
	        if (head == null)
	            head = currNode;
	        else
	            tail.next = currNode;
	        
	        tail = currNode;
	    }
	    
	    // set the next of the tail to null in order to avoid cycles
	    tail.next = null;
	    
	    return head;
	}
	
	public static void main(String[] args) {
		Node list = new Node(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		
		printList(list);
		Node copy = copyList(list);
		printList(list);
		printList(copy);
		
		Node move = moveElements(list);
		printList(list);
		printList(move);
		
		Node ordered = insertOrdered(null, 4);
		ordered = insertOrdered(ordered, 3);
	    printList(ordered);
	    Node r = Reverse(ordered);
	    printList(r);
	}
}
