// https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
    SinglyLinkedListNode newHead = head, prev = null;

    if (position == 0) {
        return head != null ? head.next : null;
    }

    for (; head != null && position > 0; prev = head, head = head.next, position--);

    if (head != null) {
        prev.next = head.next;
    }

    return newHead;
}
