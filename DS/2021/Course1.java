import java.util.Stack;

public class Course1 {
	public static void printList(Node head) {
		for (; head != null; head = head.next) {
			System.out.print(head + " ");
		}

		System.out.println();
	}

	public static int length(Node head) {
		int size = 0;

		for (; head != null; head = head.next) {
			size++;
		}

		return size;
	}

	public static int lengthRecursive(Node head) {
		if (head == null) {
			return 0;
		}

		return 1 + lengthRecursive(head.next);
	}

	public static void printListReversed(Node head) {
		Stack<Node> stack = new Stack<>();

		for (; head != null; head = head.next) {
			stack.push(head);
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

		System.out.println();
	}

	public static void printListReversedRecursive(Node head) {
		if (head == null) {
			return;
		}

		printListReversedRecursive(head.next);

		System.out.print(head.data + " ");
	}

	public static Node findFirstEven(Node head) {
		for (; head != null ; head = head.next) {
			if (head.data % 2 == 0) {
				return head;
			}
		}

		return null;
	}

	public static Node findLastEven(Node head) {
		Node lastEven = null;

		for (; head != null; head = head.next) {
			if (head.data % 2 == 0) {
				lastEven = head;
			}
		}

		return lastEven;
	}

	public static Node insertAtBeginning(Node head, int data) {
		Node aux = new Node(data);

		aux.next = head;

		return aux;
	}

	public static Node insertAtEnd(Node head, int data) {
		Node aux = new Node(data), last = null, headCopy = head;

		for (; head != null; last = head, head = head.next);

		if (last != null) {
			last.next = aux;
		} else {
			headCopy = aux;
		}

		return headCopy;
	}

	public static void insertAfter(Node head, int data, int searched) {
		Node aux = new Node(data);

		for (; head != null; head = head.next) {
			if (head.data == searched) {
				break;
			}
		}

		if (head == null) {
			return;
		}

		aux.next = head.next;

		head.next = aux;
	}

	public static Node insertBefore(Node head, int data, int searched) {
		Node aux = new Node(data), previous = null, headCopy = head;

		for (; head != null; previous = head, head = head.next) {
			if (head.data == searched) {
				break;
			}
		}

		// searched value could not be found
		if (head == null) {
			return headCopy;
		}

		// insert at beginning
		if (previous == null) {
			aux.next = headCopy;

			return aux;
		}

		previous.next = aux;

		aux.next = head;

		return headCopy;
	}

	public static Node removeFromList(Node head, int data) {
		Node previous = null, copyHead = head;

		for (; head != null; previous = head, head = head.next) {
			if (head.data == data) {
				break;
			}
		}

		if (head == null) {
			return copyHead;
		}

		// delete from beginning
		if (previous == null) {
			return copyHead.next;
		}

		previous.next = head.next;

		return copyHead;
	}

	public static void main(String[] args) {
		Node node = new Node(0);

		// print a simple node (with toString already override in Node class)
		System.out.println(node);

		// create a list (with append method created in Node class)
		Node list = new Node(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);

		// print a list
		printList(list);

		// compute the length
		System.out.println(length(list));

		// compute the length recursively
		System.out.println(lengthRecursive(list));

		// print a list in reversed order
		printListReversed(list);

		// print a list in reversed order, recursively
		printListReversedRecursive(list);

		System.out.println();

		// find the very first even element
		System.out.println(findFirstEven(list));

		// find the last even element
		System.out.println(findLastEven(list));

		// insert a new value at the beginning of the list
		printList(insertAtBeginning(list, 0));
		printList(list); // Note that the original list DOES NOT change

		// insert a new value at the end of the list
		list = insertAtEnd(list, 6);
		printList(list); // Note that the original DOES change

		// insert a new value after element 3 in the list
		insertAfter(list, 100, 3);
		printList(list); // Note that the original DOES change

		// insert a new value before element 5 in the list
		list = insertBefore(list, 300, 5);
		printList(list);
		list = insertBefore(list, 300, 7);
		printList(list);
		list = insertBefore(list, 500, 1);
		printList(list);

		// remove element 300 from list
		list = removeFromList(list, 300);
		printList(list);
		list = removeFromList(list, 100);
		printList(list);
		list = removeFromList(list, 500);
		printList(list);
	}
}
