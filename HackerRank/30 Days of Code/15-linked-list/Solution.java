// https://www.hackerrank.com/challenges/30-linked-list    
    public static  Node insert(Node head, int data) {
        //Complete this method
        Node aux = new Node(data);
        Node prev = null, list = head;
        
        for (; head != null; prev = head, head = head.next);
        
        if (prev == null)
            return aux;
        
        prev.next = aux;
        
        return list;
    }
