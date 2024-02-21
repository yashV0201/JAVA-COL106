import java.util.Arrays;

public class aggressiveCows {

    static int optimal(int[]a, int k){
        int n = a.length;
        Arrays.sort(a);

        int low =1, high = a[n-1]-a[0], ans =-1;
        while(low<=high){
            int mid=(low+high)/2;
            int count=1, last=a[0];
            for(int i =0;i<n; i++){
                if(a[i]-last>=mid){
                    count++;
                    last= a[i];
                }
            }

            if(count<k){
                high = mid-1;
            }
            else{
                ans = mid;
                low = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int a = optimal(new int[]{0,3,4,7,10,9},2);
        System.out.println(a);
    }
    
}
