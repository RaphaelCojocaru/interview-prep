/*  
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;
    
*/ 
// https://www.hackerrank.com/challenges/tree-huffman-decoding
public boolean isLeaf(Node root) {
    if (root == null) {
        return false;
    }

    if (root.left == null && root.right == null) {
        return true;
    }

    return false;
}

void decode(String s, Node root) {
    Node aux;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length();) {
        aux = root;

        while (i <= s.length()) {
            if (s.charAt(i) == '0') {
                aux = aux.left;
            } else {
                aux = aux.right;
            }

            i++;

            if (isLeaf(aux)) {
                sb.append(aux.data);

                break;
            }
        }
    }

    System.out.println(sb);
}
