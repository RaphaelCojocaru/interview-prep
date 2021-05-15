// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
static void printLinkedList(SinglyLinkedListNode head) {
    for (; head != null; head = head.next) {
        System.out.println(head.data);
    }
}
