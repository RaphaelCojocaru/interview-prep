    // https://www.hackerrank.com/challenges/30-linked-list-deletion
    public static Node removeDuplicates(Node head) {
        //Write your code here
        Node list = head, next = null;
        
        for (; head != null; head = head.next) {
            next = head.next;
            while (next != null && head.data == next.data) 
                next = next.next;
            
            head.next = next;
        }
        
        return list;
    }