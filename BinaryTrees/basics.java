import java.util.LinkedList;
import java.util.Queue;



class Node{
    int data;
    Node left;
    Node right;

    Node(int data1){
        this.data= data1;
        this.left = null;
        this.right = null;
    }
}





public class basics {
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root){
        if(root==null){
            
            return;
        } 
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static int count(Node root){
        if(root == null) return 0;
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        

        return leftCount+rightCount+1;
    }

    public static void levelOrder(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null)q.add(currNode.left);
                if(currNode.right != null)q.add(currNode.right);
            }
        }
    }

    public static int sum(Node root){
        if(root == null) return 0;
        return sum(root.left)+sum(root.right)+root.data;
    }

    public static int height(Node root){
        if(root == null) return 0;

        return Math.max(height(root.right), height(root.left)) +1;
    }

    public static int diameter(Node root){
        if(root == null) return 0;
        int max = Math.max(diameter(root.left),diameter(root.right));

        return Math.max(max,height(root.left)+height(root.right)+1);
    }

    static class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height1, int diam1){
            this.height = height1;
            this.diameter = diam1;  
        }
    }

    public static TreeInfo diam(Node root){                            // clever method...using TreeInfo class
        if(root == null) return new TreeInfo(0,0);
        TreeInfo left = diam(root.left); 
        TreeInfo right = diam(root.right);

        int myHeight = Math.max(left.height, right.height)+1;
        int myDiameter = Math.max(left.diameter, Math.max(right.diameter,left.height+right.height+1 ));

        return new TreeInfo(myHeight,myDiameter);
    }
 
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes); 
        levelOrder(root);
        System.out.println(diam(root).diameter);

        //System.out.println(root.left.data);
    }
}
