// https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem
public static DoublyLinkedListNode reverse(DoublyLinkedListNode list) {
    DoublyLinkedListNode prev = null, next = null;

    if (list == null || list.next == null) {
        return list;
    }

    prev = list;

    list = list.next;

    if (list.next != null) {
        next = list.next;
    }

    for (; next != null; prev = list, list = next, next = next.next) {
        // beginning of the list
        if (prev.prev == null) {
            prev.next = null;
        }

        prev.prev = list;

        list.next = prev;
    }

    if (prev.prev == null) {
        prev.next = null;
    }

    prev.prev = list;

    list.next = prev;
    list.prev = null;

    return list;
}

public static DoublyLinkedListNode reverse2(DoublyLinkedListNode list) {
    DoublyLinkedListNode prev = null, next = null;

    if (list == null) {
        return list;
    }

    while (true) {
        next = list.next;
        prev = list.prev;

        list.next = prev;
        list.prev = next;

        if (next == null) {
            break;
        }

        list = next;
    }

    return list;
}

public static DoublyLinkedListNode reverseRecursive(DoublyLinkedListNode list) {
    if (list == null) {
        return list;
    }

    DoublyLinkedListNode next = list.next;
    DoublyLinkedListNode prev = list.prev;

    list.next = prev;
    list.prev = next;

    if (next == null) {
        return list;
    }

    return reverse(next);
}