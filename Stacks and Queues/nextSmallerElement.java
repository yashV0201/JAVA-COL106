import java.util.Arrays;
import java.util.Stack;

public class nextSmallerElement {
   static int[] nse(int[] nums){
    int n = nums.length;
    int[] ans  = new int[n];
    Stack<Integer> s = new Stack<>();

    for(int i = 0; i<n;i++){
        while(!s.isEmpty() && s.peek()>=nums[i]){
            s.pop();
        }

        if(!s.isEmpty()) ans[i] = s.peek();
        else ans[i] = -1;

        s.push(nums[i]);
    }

    return ans;
   } 

   public static void main(String[] args) {
    int[] nums = {4,5,2,10,8};
    System.out.println(Arrays.toString(nse(nums)));
   }
}
