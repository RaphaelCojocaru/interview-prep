// https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
static boolean hasCycle(SinglyLinkedListNode head) {
    HashSet<SinglyLinkedListNode> set = new HashSet<>();

    for (; head != null; head = head.next) {
        if (set.contains(head)) {
            return true;
        } else {
            set.add(head);
        }
    }

    return false;
}
