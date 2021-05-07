// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    SinglyLinkedListNode newHead = null, tail = null, aux;

    Stack<SinglyLinkedListNode> stack = new Stack<>();

    for (; head != null; head = head.next) {
        stack.push(head);
    }

    while (!stack.isEmpty()) {
        aux = stack.pop();

        if (newHead == null) {
            newHead = aux;
        } else {
            tail.next = aux;
        }

        tail = aux;
    }

    tail.next = null;

    return newHead;
}
