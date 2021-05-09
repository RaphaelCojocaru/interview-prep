// https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem
static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    SinglyLinkedListNode newHead = new SinglyLinkedListNode(data);

    newHead.next = llist;

    return newHead;
}
