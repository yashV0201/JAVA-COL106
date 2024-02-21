public class shipWhithinDays {
    static int optimal(int[]a, int d){
        
        int n =  a.length, max=Integer.MIN_VALUE, sum =0;
        for(int i =0; i<n; i++){
            sum+=a[i];
            max = Math.max(a[i],max);
        }

        if(d==1) return sum;

        int low =max, high = sum, ans = -1;

        while(low<=high){
            int mid = (low+high)/2, k = mid, count = 0, x= 0;

            for(int i =0; i<n; i++){
                count+=a[i];
                if(count==k){
                    count =0;
                    x++;
                }
                else if(count>k){
                    count = a[i];
                    x++;
                }

            }

            if(count>0) x++;


            
            if(x>d){
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
        int a = optimal(new int[]{1,2,3,1,1},4);
        System.out.println(a);
    }
    
}
