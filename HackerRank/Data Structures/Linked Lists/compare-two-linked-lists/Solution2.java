// https://www.hackerrank.com/challenges/compare-two-linked-lists/problem
static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    for (; head1 != null && head2 != null; head1 = head1.next, head2 = head2.next) {
        if (head1.data != head2.data) {
            return false;
        }
    }

    if (head1 == null && head2 == null) {
        return true;
    }

    return false;
}
