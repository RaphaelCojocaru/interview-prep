	// https://www.hackerrank.com/challenges/30-binary-trees
    static void levelOrder(Node root){
        //Write your code here
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        
        while (queue.isEmpty() == false) {
            Node elem = queue.poll();
            System.out.print(elem.data + " ");
            if (elem.left != null)
                queue.offer(elem.left);
            if (elem.right != null)
                queue.offer(elem.right);
        }
    }