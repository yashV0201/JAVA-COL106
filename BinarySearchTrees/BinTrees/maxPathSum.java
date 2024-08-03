public class maxPathSum {

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

    public static int maxSum(Node root){
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        pathSum(root, max);

        return max[0];
    }

    public static int pathSum(Node root, int[] max){
        if(root == null) return 0;
        int leftSum = pathSum(root.left, max);
        int rightSum = pathSum(root.right, max);
        max[0] = Math.max(max[0], leftSum+rightSum+root.val);

        return Math.max(leftSum, rightSum)+ root.val;
    }

    public static void main(String[] args) {
        Node root = buildTree(new int[]{6,3,8,9,1,7,2,4,5});
        System.out.println(maxSum(root));
    }
}
