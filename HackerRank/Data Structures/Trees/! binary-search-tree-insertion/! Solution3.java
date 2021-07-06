 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
// https://www.hackerrank.com/challenges/binary-search-tree-insertion
public static Node insert(Node root, int data) {
    if (root == null) {
        return new Node(data);
    }

    if (data <= root.data) {
        root.left = insert(root.left, data);
    }

    if (data > root.data) {
        root.right = insert(root.right, data);
    }

    return root;
}


