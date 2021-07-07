
// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
public static Node lca(Node root, int v1, int v2) {
    Queue<Node> pathToV1 = new LinkedList<>();
    Queue<Node> pathToV2 = new LinkedList<>();

    searchValue(root, v1, pathToV1);
    searchValue(root, v2, pathToV2);

    Node lca = root, pathNode1, pathNode2;

    while (!pathToV1.isEmpty() && !pathToV2.isEmpty()) {
        pathNode1 = pathToV1.remove();
        pathNode2 = pathToV2.remove();

        if (pathNode1.data != pathNode2.data) {
            break;
        }

        lca = pathNode1;
    }

    return lca;
}

public static void searchValue(Node root, int value, Queue<Node> path) {
    path.add(root);

    if (root == null || root.data == value) {
        return;
    }

    if (value < root.data) {
        searchValue(root.left, value, path);
    }

    if (value > root.data) {
        searchValue(root.right, value, path);
    }
}
