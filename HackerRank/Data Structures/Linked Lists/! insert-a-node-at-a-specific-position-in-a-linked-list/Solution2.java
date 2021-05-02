// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
// INSERT BEFORE
public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    SinglyLinkedListNode newHead = head, prev = null, aux;

    for (; head != null && position > 0; prev = head, head = head.next, position--);

    aux = new SinglyLinkedListNode(data);

    if (prev == null) {
        aux.next = head;

        newHead = aux;
    } else {
        aux.next = prev.next;

        prev.next = aux;
    }

    return newHead;
}
