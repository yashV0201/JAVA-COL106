import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;



class Node{
    int data;
    Node left;
    Node right;

    Node(){}

    Node(int data1){
        this.data = data1;
        this.left = null;
        this.right = null;
    }
}



public class basics {
    
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }


        return root;
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);
            }

            else{
                System.out.print(curr.data +" ");
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right);
            }
        }

    }


    public static boolean search(Node root, int key){
        if(root == null) return false;
        if(root.data<key){
            return search(root.right, key);
        }
        else if(root.data == key) return true;

        else return search(root.left,key);
    }

    public static Node delete(Node root, int val){
        if(root == null) return null;
        if(root.data < val) root.right =  delete(root.right, val);
        else if(root.data > val) root.left =  delete(root.left, val);
        else{
            if(root.left == null && root.right == null){
                return null;
            }

            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            Node IS = InorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }

        return root;

    }

    public static Node InorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }

        return root;    
    }

    public static void printPath(ArrayList<Integer> path){
        for(int ele: path){
            System.out.print(ele + "->");
        }
        System.out.println();
    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null) return;

        
        path.add(root.data);

        if(root.left == null && root.right == null) printPath(path);
        else{
            printRootToLeaf(root.left, path);
            printRootToLeaf(root.right, path);

        }
        path.remove(path.size()-1);
    }


    public static void main(String[] args) {
        int[] arr = {5,1,3,4,2,7};
        Node root = null;

        for(int ele : arr){
            root = insert(root,ele);
        }

        // insert(root,6);
        //  levelOrder(root);

        //inorder(root);
        // System.out.println(search(root,6));

        //delete(root, 3);
        // inorder(root);

        //printRootToLeaf(root, new ArrayList<>());

    }
}
