   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
// https://www.hackerrank.com/challenges/tree-level-order-traversal
void levelOrder(Node root) {
    LinkedList<Node> queue = new LinkedList<Node>();
        
    if (root == null)
        return;
    
    queue.add(root);
    while (queue.isEmpty() == false) {
        Node currNode = queue.removeFirst();
        System.out.print(currNode.data + " ");
        if (currNode.left != null)
            queue.add(currNode.left);
        if (currNode.right != null)
            queue.add(currNode.right);
    }
}
