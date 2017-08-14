/* 
    class Node 
    int data;
    Node left;
    Node right;
*/

// https://www.hackerrank.com/challenges/tree-top-view
public static void leftView(Node root) {
    if (root == null)
        return;
    
    leftView(root.left);
    System.out.print(root.data + " ");
}

public static void rightView(Node root) {
    if (root == null)
        return;
    
    System.out.print(root.data + " ");
    rightView(root.right);
}

public static void topView(Node root) {
    if (root == null)
        return;
    
    leftView(root.left);
    System.out.print(root.data + " ");
    rightView(root.right);
      
}
