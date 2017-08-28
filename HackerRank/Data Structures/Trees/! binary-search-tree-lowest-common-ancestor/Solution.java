
// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
public static boolean withinTree(Node root, int value) {
    if (root == null)
        return false;
    
    if (root.data == value)
        return true;
    
    return (withinTree(root.left, value) || withinTree(root.right, value));
}

public static Node lca(Node root, int v1, int v2) {
    if (root == null)
        return null;
    
    if (root.data == v1 || root.data == v2)
        return root;
    
    boolean left1 = withinTree(root.left, v1);
    boolean left2 = withinTree(root.left, v2);
    
    if (left1 != left2)
        return root;
  
    if (left1 == true)
        return lca(root.left, v1, v2);
  
    return lca(root.right, v1, v2);
}




