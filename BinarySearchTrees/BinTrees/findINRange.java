public class findINRange {
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
    public static void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void findInRange(Node root, int X, int Y){
        if(root == null) return;

        if(root.val>=X && root.val <=Y){
            findInRange(root.left, X, Y);
            System.out.print(root.val+" ");
            findInRange(root.right, X, Y);
        }
        else if(root.val < X){
            findInRange(root.right, X, Y);
        }

        else{
            findInRange(root.left, X, Y);
        }
    }

    public static void main(String[] args) {
        Node root = buildTree(new int[]{6,3,8,9,1,7,2,4,5});
        inorder(root);
        System.out.println();
        findInRange(root, 7, 9);
    }






}
