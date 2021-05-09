// https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    SinglyLinkedListNode originalHead = head, prev = null, aux;

    for (; head != null; prev = head, head = head.next);

    aux = new SinglyLinkedListNode(data);

    // it means there are no elements in the original list
    if (prev == null) {
        originalHead = aux;
    } else {
        aux.next = prev.next;

        prev.next = aux;
    }

    return originalHead;
}
