/* 
    class Node 
    int data;
    Node left;
    Node right;
*/

// https://www.hackerrank.com/challenges/tree-top-view
public static void topView(Node root) {
    if (root == null) {
        return;
    }

    topViewLeft(root.left);

    System.out.print(root.data + " ");

    topViewRight(root.right);
}

public static void topViewLeft(Node root) {
    if (root == null) {
        return;
    }

    topViewLeft(root.left);

    System.out.print(root.data + " ");
}

public static void topViewRight(Node root) {
    if (root == null) {
        return;
    }

    System.out.print(root.data + " ");

    topViewRight(root.right);
}
