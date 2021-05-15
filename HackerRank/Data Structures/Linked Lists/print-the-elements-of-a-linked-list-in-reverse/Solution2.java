// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
public static void reversePrintRecursive(SinglyLinkedListNode llist) {
    if (llist == null) {
        return;
    }

    reversePrint(llist.next);

    System.out.println(llist.data);
}

public static void reversePrint(SinglyLinkedListNode llist) {
    Stack<SinglyLinkedListNode> stack = new Stack<>();

    SinglyLinkedListNode aux;

    for (; llist != null; llist = llist.next) {
        stack.push(llist);
    }

    while (!stack.isEmpty()) {
        aux = stack.pop();

        System.out.println(aux.data);
    }
}
