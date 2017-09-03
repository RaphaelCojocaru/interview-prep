	// https://www.hackerrank.com/challenges/30-binary-search-trees
    public static int getHeight(Node root){
        //Write your code here
        if (root == null)
            return -1;
        
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
