class Node{
    int val;
    Node left;
    Node right;

    
    Node(){}

    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


public class basics{

        public static Node insert(Node root, int val){
            if(root== null){
                root = new Node(val);
                return root;
            }

            if(root.val>val){
                root.left =  insert(root.left, val);
            }
            else{
                root.right = insert(root.right, val);
            }

            return root;
        }


        public static void inorder(Node root){
            if(root == null) return;

            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }


    public static void main(String[] args) {
        int[] a = {5,3,7,8,9,1,2,4};
        Node root = null;
        for(int x:a){
            root = insert(root,x);
 
        }

        inorder(root);

    }

}