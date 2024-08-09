import java.util.LinkedList;
import java.util.Queue;



class Tuple{
    Node node;
    int x;

    Tuple(Node node, int x){
        this.node = node;
        this.x = x;
    }
}

public class maxWidth {
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

    
    public static int maxW(Node root){
        if(root==null) return 0;

        int ans =0;
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(root, 0));
        while(!q.isEmpty()){
            int n = q.size();
            int min = q.peek().x;
            int first =0, last = 0;
            for(int i=0; i<n;i++){
                Tuple t = q.poll();
                int index = t.x-min;
                Node node = t.node;
                if(i==0) first = index;
                if(i==n-1) last = index;
                if(node.left != null){
                    q.add(new Tuple(node.left, 2*index+1));
                }
                if(node.right != null){
                    q.add(new Tuple(node.right, 2*index+2));
                }

            }

            ans = Math.max(ans, last-first+1);
        }
        

        return ans;
    }

    public static void main(String[] args) {
        Node root = buildTree(new int[]{8,5,9,3,2,4,1,6,7});
        System.out.println(maxW(root));
    }
    
}
