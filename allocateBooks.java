import java.util.ArrayList;
import java.util.Arrays;

public class allocateBooks {
    static int optimal(ArrayList<Integer>a, int m){
        int n = a.size(), max = 0, min = Integer.MIN_VALUE;
        for(int i =0; i<n; i++){
            max+=a.get(i);
            min = Math.max(min, a.get(i));
        }

        int low = min, high = max, ans = -1;
        while(low<=high){
            int mid=(low+high)/2, count =0, sum = 0;
            for(int i=0;i<n; i++){
                if(sum+a.get(i)>mid){
                    sum = a.get(i);
                    count++;
                    
                }
                else{
                    
                    sum += a.get(i);
                }
            }

            if(sum>0) count++;

            if(count>m){
                low = mid+1;
            }

            else{
                ans = mid;
                high = mid-1;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        Integer[] arr = {12, 34, 67, 90};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        int a = optimal(list,2);
        System.out.println(a);
    }
}
