// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode head = null, tail = null, aux = null;

    while (head1 != null && head2 != null) {
        if (head1.data <= head2.data) {
            aux = head1;

            head1 = head1.next;
        } else {
            aux = head2;

            head2 = head2.next;
        }

        if (head == null) {
            head = aux;
        } else {
            tail.next = aux;
        }

        tail = aux;
    }

    for (; head1 != null; head1 = head1.next) {
        if (head == null) {
            head = head1;
        } else {
            tail.next = head1;
        }

        tail = head1;
    }

    for (; head2 != null; head2 = head2.next) {
        if (head == null) {
            head = head2;
        } else {
            tail.next = head2;
        }

        tail = head2;
    }

    tail.next = null;

    return head;
}
