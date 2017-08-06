	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    //https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
	static int height(Node root) {
      	// Write your code here.
        if (root == null)
            return -1;
        
        int left = height(root.left);
        int right = height(root.right);
        
        return 1 + Math.max(left, right);
    }
