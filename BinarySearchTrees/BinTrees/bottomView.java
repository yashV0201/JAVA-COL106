import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class bottomView {
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

    

    public static ArrayList <Integer> bottom(Node root)
    {
        // Code here
        TreeMap<Integer, Integer> verticals = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        ArrayList<Integer> list = new ArrayList<>();
        q.add(new Tuple(root, 0));
        while(!q.isEmpty()){
            Tuple t= q.poll();
            Node node = t.node;
            int x = t.x;


            
            verticals.put(x,node.val);
            


            if(node.left != null) q.add(new Tuple(node.left, x+1));
            if(node.right != null) q.add(new Tuple(node.right, x+1));

        }

        for(Integer a : verticals.values()){
            list.add(a);
        }

        return list;
    }
    
    public static void main(String[] args) {
        Node root = buildTree(new int[]{8,5,9,3,2,4,1,6,7});
       
        System.out.println(bottom(root).toString());
    }
    
}
