import java.util.ArrayList;
import java.util.List;

public class rootToLeavesPath {
    
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

    public static void path(Node root, List<Integer> list){

        if(root == null) return;

        list.add(root.val);
        if(root.left == null && root.right == null){
            for(int a: list){
                System.out.print(a+"->");
            }
            System.out.println();
            list.remove(list.size()-1);
            return;
        }

        else{
            path(root.left, list);
            path(root.right, list);
        }
        
        list.remove(list.size()-1);
        return;

    }

    public static void root2leaf(Node root, List<Integer> list){  //self coded
        list.add(root.val);
        if(root.left == null && root.right == null){
            for(int a: list){
                System.out.print(a+"->");
            }
            System.out.println();
            list.remove(list.size()-1);
            return;
        }
        else if(root.left != null && root.right == null){
            root2leaf(root.left, list);
        }
        else if(root.right != null && root.left == null){
            root2leaf(root.right, list);
        }
        else{
            root2leaf(root.left, list);
            root2leaf(root.right, list);
        }

        list.remove(list.size()-1);
        return;
    }

    public static void main(String[] args) {
        Node root = buildTree(new int[]{6,3,8,9,1,7,2,4,5});
        inorder(root);
        System.out.println();
        path(root, new ArrayList<Integer>());
    }


}
