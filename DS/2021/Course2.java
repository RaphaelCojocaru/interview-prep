
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Course2 {
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

	public static Node copyList(Node head) {
		Node newHead = null, tail = null, aux;

		for (; head != null; head = head.next) {
			aux = new Node(head.data * 10);

			if (newHead == null) {
				newHead = aux;
			} else {
				tail.next = aux;
			}

			tail = aux;
		}

		return newHead;
	}

	// Move even numbers into a different list
	public static List<Node> splitList(Node head) {
		Node newHead = null, tail = null, prev = null, originalHead = head;

		for (; head != null; prev = head, head = head.next) {
			// build the new list containing elements to be moved
			while (head != null && head.data % 2 == 0) {
				if (newHead == null) {
					newHead = head;
				} else {
					tail.next = head;
				}

				tail = head;

				head = head.next;
			}

			// trim the existing list by removing the even elements
			if (prev == null) {
				originalHead = head;
			} else {
				prev.next = head;
			}

			if (head == null) {
				break;
			}
		}

		// mark the ending of new list
		tail.next = null;

		return Arrays.asList(newHead, originalHead);
	}

	public static Node insertSorted(Node head, int value) {
        Node originalHead = head, prev = null, aux;

        for (; head != null; prev = head, head = head.next) {
            if (head.data > value) {
                break;
            }
        }

        aux = new Node(value);

        // insert at beginning
        if (prev == null) {
            aux.next = originalHead;

            return aux;
        } else { // insert before first elem greated than value
            // we use the prev pointer to store the element before the greater value
            aux.next = prev.next;

            prev.next = aux;
        }

        return originalHead;
    }

    public static void main(String[] args) {
        // create a list (with append method created in Node class)
        Node list = new Node(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        // make a copy of the list
        System.out.print("Orig list => ");
        printList(list);
        Node copy = copyList(list);
        System.out.print("Copy list => ");
        printList(copy);
        System.out.println();

        // move even values from the list
        List<Node> results = splitList(list);
        System.out.print("Orig list => ");
        printList(list);
        Node even = results.get(0);
        Node odd = results.get(1);
        System.out.print("Even nodes => ");
        printList(even);
        System.out.print("Oddd nodes => ");
        printList(odd);
        System.out.println();

        Node list2 = new Node(2);
        list2.append(4);
        list2.append(6);
        list2.append(1);
        list2.append(3);
        list2.append(2);
        list2.append(5);
        list2.append(8);
        System.out.print("Orig list => ");
        printList(list2);
        // move even values from the list2
        List<Node> results2 = splitList(list2);
        Node even2 = results2.get(0);
        Node odd2 = results2.get(1);
        System.out.print("Even nodes => ");
        printList(even2);
        System.out.print("Oddd nodes => ");
        printList(odd2);

        Node list3 = new Node(10);
        System.out.print("Orig list => ");
        printList(list3);
        Random generator = new Random();
        for (int i = 0; i < 10; i++) {
            int randomValue = generator.nextInt(20);
            list3 = insertSorted(list3, randomValue);
            System.out.print("List after inserting " + randomValue + " => ");
            printList(list3);
        }


    }
}
