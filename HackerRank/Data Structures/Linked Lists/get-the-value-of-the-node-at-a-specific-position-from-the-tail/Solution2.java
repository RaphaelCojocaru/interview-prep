// https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
public static int getNode(SinglyLinkedListNode list, int positionFromTail) {
    Stack<SinglyLinkedListNode> stack = new Stack<>();
    SinglyLinkedListNode node;

    for (; list != null; list = list.next) {
        stack.push(list);
    }

    if (positionFromTail > stack.size()) {
        return -1;
    }

    for (int i = 0; i < positionFromTail; i++) {
        stack.pop();
    }

    node = stack.pop();

    return node.data;
}
