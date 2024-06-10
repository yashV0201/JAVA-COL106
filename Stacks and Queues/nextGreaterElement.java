import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class nextGreaterElement {
    static int[] brute(int[] a){
        int n = a.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int k = a[i];
            for(int j=i;j<i+n;j++){
                if(a[j%n]>k){
                    ans[i]=a[j%n];
                    break;
                }
                else ans[i] = -1;
            }
        }


        return ans;
    }

    static int[] optimal(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s =new Stack<>();
        for(int i=2*n-1; i>=0;i--){
            while(!s.isEmpty() && nums[i%n]>=s.peek()){
                s.pop();
            }

            if(i<n){
                if(!s.isEmpty()) ans[i] = s.peek();
                else ans[i] = -1;
            }

            s.push(nums[i%n]);
        }
        return ans;
    }

    static int[] notOptimal2(int[] nums1, int[] nums2){
        int n = nums1.length;
        int[] ans = new int[n];
        
        for(int i=0;i<n;i++){
            Stack<Integer> s = new Stack<>();
            for(int j = nums2.length-1;j>=0;j--){
                while(!s.isEmpty() && s.peek()<=nums2[j]){
                    s.pop();
                }
                if(nums1[i] == nums2[j]){
                    if(!s.isEmpty()){
                        ans[i] = s.peek();
                    }else ans[i] = -1;
                    break;
                }
                s.push(nums2[j]);
            }
        }

        return ans;
    }

    static int[] optimal2(int[] nums1, int[] nums2){
        int n = nums1.length;
        int[] ans  = new int[n];

        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> hm =new HashMap<>();
        int[] res = new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums2[i]){
                s.pop();
            }

            if(!s.isEmpty()) res[i] = s.peek();
            else res[i] = -1;
            
            s.push(nums2[i]);
        }

        for(int i=0; i<nums2.length;i++){
            hm.put(nums2[i], res[i]);
        }

        for(int i=0; i<n;i++){
            ans[i] = hm.get(nums1[i]);
        }


        return ans;
    }


    public static void main(String[] args) {
        int[] a = {5,7,1,7,6,0};
        int[] nums1 ={4,1,2};
        int[] nums2 ={4,1,3,2};

        System.out.println(Arrays.toString(optimal(a)));
        System.out.println(Arrays.toString(optimal2(nums1, nums2)));
    }
}
