public class upperBound {

    static int floor(int[]a, int k){
        int low =0, high = a.length-1, ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]<=k){
                ans =mid;
                low = mid+1;

            }
            else{
                high = mid-1;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int ub = floor(new int[]{1,2,5,5,6,8,9,10},5);
        System.out.println(ub);
    }
    
}
