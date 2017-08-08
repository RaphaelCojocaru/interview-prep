 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
// https://www.hackerrank.com/challenges/binary-search-tree-insertion
static Node Insert(Node root, int value) {

    if (root == null) {
        Node aux = new Node();
        aux.data = value;
        return aux;
    }

    if (value < root.data)
        root.left = Insert(root.left, value);
        
    if (value > root.data)
        root.right = Insert(root.right, value);
    
    return root;
}


