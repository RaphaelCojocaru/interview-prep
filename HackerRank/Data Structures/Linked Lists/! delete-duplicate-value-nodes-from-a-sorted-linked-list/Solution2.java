// https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
    SinglyLinkedListNode newHead = null, prev = null;

    for (; head != null; prev = head, head = head.next) {
        while (head.next != null && head.data == head.next.data) {
            head = head.next;
        }

        if (prev == null) {
            newHead = head;
        } else {
            prev.next = head;
        }
    }

    return newHead;
}
