   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
// https://www.hackerrank.com/challenges/tree-level-order-traversal
public static void levelOrder(Node root) {
    Node current;
    Queue<Node> queue = new LinkedList<>();

    if (root == null) {
        return;
    }

    queue.add(root);

    while (!queue.isEmpty()) {
        current = queue.remove();

        System.out.print(current.data + " ");

        if (current.left != null) {
            queue.add(current.left);
        }

        if (current.right != null) {
            queue.add(current.right);
        }
    }
}
