// sorted linked list contains a given value
public boolean containsElement(Node head, int value) {
    if (head == null)
      return false;

    Node curr = head;
    head = head.next;

    if (curr.info == head.info && curr.info != value)
      return false;

    for (; ; curr = head, head = head.next) {
      if (curr.info == value)
        return true;
      if (curr.info > head.info && curr.info < value)
        return false;
      if (curr.info > head.info && value < head.info)
        return false;
      if (curr.info < value && value < head.info)
        return false;
    }
  }