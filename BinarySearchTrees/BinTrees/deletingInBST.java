class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class deletingInBST {

    public static Node buildTree(int[]a){
        Node root = null;

        for(int x:a){
            root = insert(root,x);
        }

        return root;
    }

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


    public static Node delete(Node root, int val){
        if(root.val>val){
            root.left = delete(root.left, val);
        }
        else if(root.val <val){
            root.right = delete(root.right, val);
        }
        else{
            if(root.right==null && root.left == null){
                return null;
            }

            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            Node IS = inorderSuccessor(root.right);
            root.val = IS.val;
            root.right =  delete(root.right, IS.val);
        }

        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
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
        Node root = buildTree(new int[]{6,3,8,9,1,7,2,4,5});
        inorder(root);
        System.out.println();
        delete(root, 8);
        inorder(root);

    }

    
}
