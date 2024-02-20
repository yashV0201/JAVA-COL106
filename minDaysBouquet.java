public class minDaysBouquet {
    static int optimal(int[]a, int m , int k){
        if(m*k > a.length) return -1;

        int n = a.length;
        int min = Integer.MAX_VALUE, max= Integer.MIN_VALUE;
        for(int i =0; i<n; i++){
            max = Math.max(a[i],max);
            min = Math.min(a[i],min);
        }

        int low = min, high = max, ans = -1;

        while(low<=high){
            int mid =(low+high)/2;
            int t = mid,  x =0;
            for(int i = 0; i<n; i++){
                int count =0;
                if(a[i]<=t){
                    count++;
                    if(count ==k){
                        count =0;
                        x++;
                    }
                }
                else{
                    count =0;
                }
            }

            if(x<m){
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
        int a = optimal(new int[]{7,7,7,7,12,7,7},2,3);
        System.out.println(a);
    }
    
}
