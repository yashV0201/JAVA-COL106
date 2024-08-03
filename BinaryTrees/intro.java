class Node{
    int value;
    Node left;
    Node right;

    Node(int value){
        this.left = null;
        this.right =null;
        this.value= value;

    }
}


public class intro {

    public static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] a){ //array data should be in preorder sequence
            idx++;
            if(a[idx] == -1) return null;
            Node newNode = new Node(a[idx]);
            newNode.left = buildTree(a);
            newNode.right = buildTree(a);

            return newNode;
        }
    }


}
