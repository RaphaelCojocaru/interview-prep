// https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode l, int data) {
    DoublyLinkedListNode head = l, prev = null, aux = null;

    for (; l != null && l.data < data; prev = l, l = l.next);

    aux = new DoublyLinkedListNode(data);

    if (prev == null) {
        aux.next = l;

        if (l != null) {
            l.prev = aux;
        }

        return aux;
    } else {
        aux.next = l;
        aux.prev = prev;

        prev.next = aux;

        if (l != null) {
            l.prev = aux;
        }
    }

    return head;
}
