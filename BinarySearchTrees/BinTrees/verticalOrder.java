import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

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

public class verticalOrder {
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

    static void verticalOrd(Node root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> verticals){
        if(root == null) return;

        if(verticals.get(x) == null){
            verticals.put(x,new TreeMap<>());
        }
        if(!verticals.get(x).containsKey(y)){
            verticals.get(x).put(y, new PriorityQueue<>());
        }

        //go to left subtree
        verticalOrd(root.left, x-1, y+1, verticals);

        //this node
        verticals.get(x).get(y).offer(root.val);

        //right node
        verticalOrd(root.right, x+1, y+1, verticals);

        return;

    }

    public static void main(String[] args) {
        Node root = buildTree(new int[]{8,5,9,3,2,4,1,6,7});

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> verticals = new TreeMap<>();
        verticalOrd(root, 0, 0, verticals);
        List<List<Integer>> list = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> inn : verticals.values()){
            List<Integer> row = new ArrayList<>();
            list.add(row);
            for(PriorityQueue<Integer> node : inn.values()){
                while(!node.isEmpty()){
                    list.get(list.size()-1).add(node.poll());
                }
                
            }

            
        }

        System.out.println(list.toString());

    }


}
