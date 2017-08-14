/*  
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;
    
*/ 
// https://www.hackerrank.com/challenges/tree-huffman-decoding
void decode(String S, Node root) {
    Node aux;
    int i = 0;
    
    while (i < S.length()) {
        aux = root;
        while (aux.left != null || aux.right != null) {
            if (S.charAt(i) == '0')
                aux = aux.left;
            else
                aux = aux.right;
            i++;
        }
        System.out.print(aux.data);
    }
       
}
