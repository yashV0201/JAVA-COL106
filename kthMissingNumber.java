public class kthMissingNumber {
    static int brute(int[]a, int k){
        if(a[0]>k) return k;
        int n = a.length, x = k, i=0;
        while(i<n && x>=a[i]){
            x+=1;
            i++;

        }

        return x;

    }

    static int optimal(int[]a, int k){
        if(a[0]>k) return k;
        int n = a.length, low =0, high = n-1;
        while(low<= high){
            int mid =(low+high)/2;
            if(a[mid]-mid-1<k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return high+k+1;
        
    }



    public static void main(String[] args) {
        int a = optimal(new int[]{1,2,3,4},2);
        System.out.println(a);
    }
    
}
