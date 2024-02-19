public class findingPeakElement {
    static int optimal(int[]a){
        int n = a.length;
        if(n==1) return 0;
        if(a[0]>a[1]) return 0;
        if(a[n-1]>a[n-2]) return n-1;
        
        int low = 1, high= n-2, ind =-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]>a[mid-1]&& a[mid]>a[mid+1]){ind = mid; break;}
            else if(a[mid]>a[mid-1]){
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        } 

        return ind;
    }
    
    public static void main(String[] args) {
        int a= optimal(new int[]{1,2,3,4,5,6,8,7,10,9});
        System.out.println(a);
    }
}
