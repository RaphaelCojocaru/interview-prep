// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    Stack<SinglyLinkedListNode> stack1 = new Stack<>();
    Stack<SinglyLinkedListNode> stack2 = new Stack<>();

    SinglyLinkedListNode node1, node2, last = null;

    for (; head1 != null; head1 = head1.next) {
        stack1.push(head1);
    }

    for (; head2 != null; head2 = head2.next) {
        stack2.push(head2);
    }

    while (!stack1.isEmpty() && !stack2.isEmpty()) {
        node1 = stack1.pop();
        node2 = stack2.pop();

        if (node1 != node2) {
            break;
        }

        last = node1;
    }

    return last != null ? last.data : -1;
}
