/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
// https://www.hackerrank.com/challenges/is-binary-search-tree
boolean checkBST(Node root) {
    return checkAux(root, Integer.MIN_VALUE, Integer.MAX_VALUE);    
}

boolean checkAux(Node root, int min, int max) {
    if (root == null)
        return true;
    if (root.data <= min)
        return false;
    if (root.data >= max)
        return false;
    return checkAux(root.left, min, root.data) && checkAux(root.right, root.data, max);
}
