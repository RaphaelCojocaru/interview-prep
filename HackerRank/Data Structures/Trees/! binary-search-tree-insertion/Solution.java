 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
// https://www.hackerrank.com/challenges/binary-search-tree-insertion
static Node Insert(Node root, int value) {
    Node aux = new Node();
    aux.data = value;
    
    Node tree = root;
    
    if (root == null)
        return aux;
        
    while (root != null) {
        if (root.data == value)
            return tree;
        if (value < root.data && root.left == null) {
            root.left = aux;
            return tree;
        } else if (value < root.data)
            root = root.left;
        
        if (value > root.data && root.right == null) {
            root.right = aux;
            return tree;
        } else if (value > root.data)
            root = root.right;
    }
       
    return tree;
}


