public class sqrtOfANumber {

    static int sqrt(int n){
        if(n==1) return 1;
        int low =0, high = n/2,ans = -1;
        while(low<=high){
            int mid=(low+high)/2;
            if(mid*mid<=n){
                ans = mid;
                low = mid+1;
            }

            else high = mid-1;
        }

        return ans;
        
    }

    public static void main(String[] args) {
        int a = sqrt(4);
        System.out.println(a);
    }
    
}
