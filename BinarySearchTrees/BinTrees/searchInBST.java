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


public class searchInBST {

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

    public static boolean search(Node root, int key){
        if(root== null) return false;

        if(root.val>key){
            System.out.println(root.val);
            return search(root.left,key);
        }

        else if(root.val==key){
            return true;
        }

        else{
            // System.out.println(root.val);
            return search(root.right,key);
        }
    }

    public static void main(String[] args) {
        Node root = buildTree(new int[]{8,5,9,3,2,4,1,6,7});
        System.out.println(search(root, 1));
    }
}
