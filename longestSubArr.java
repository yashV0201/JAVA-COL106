import java.util.HashMap;
import java.util.Map;

public class longestSubArr {

    static int subArr(int[] a, int k){

        int c_max = -1;
        for(int i=0; i<a.length;i++){
            int left=i;
            int sum=0;
            int count= 0;
            while(left<a.length && sum<k){
                count++;
                sum = sum +a[left];
                left++;


            }
            if(sum == k){c_max = Math.max(c_max, count);}
            else continue;
            
        }

        return c_max;
    }

    static int longestSub(int[] arr, int k ){ // approach: using hashing and reverse mathematics
        Map<Integer, Integer> hm = new HashMap<>();
        int maxLen=0;
        int sum = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum == k) maxLen = Math.max(maxLen, i+1);

            int rem = sum - k;

            if(hm.containsKey(rem)){
                int len = i- hm.get(rem);
                maxLen = Math.max(maxLen, len);

            }
            
            if(! hm.containsKey(rem)){
                hm.put(sum, i);
            }
        }

        return maxLen;


    }

    static int optimal(int[] a, int k){  //two pointer approach => optimal for the case when all the elements are non-zero, positive 
        int left=0, right = 0;
        int sum = a[0];
        int maxLen = 0;
        while(right < a.length){
            while(left<=right && sum>k){   //if sum exceeds the given value then trim from behind;
                sum -= a[left];
                left++;
            }

            if(sum==k){
                maxLen = Math.max(maxLen, right-left +1);
            }
            
            right ++;
            if(right<a.length)sum+=a[right];

        }
        return maxLen;

    }

    public static void main(String[] args) {
        int a = subArr(new int[]{2,3,5,1,1,1,1,-1,2,2,2,9}, 9);
        int b = longestSub(new int[]{2,3,5,1,1,1,1,2,2,2,-1,9}, 4);
        int c = optimal(new int[]{2,3,5,1,1,1,1,2,2,2,9}, 9);

        System.out.println(a +" "+b+" "+c);
    }
    
}
