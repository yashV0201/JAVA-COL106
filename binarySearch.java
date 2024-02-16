public class binarySearch {

    static boolean bsIter(int[]a, int k){
        
        int low = 0;
        int high = a.length-1;

        while(low<=high){
            int mid  = (low+high)/2;
            if(a[mid] == k) return true;
            else if(a[mid]<k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return false;

    }

    static boolean recursive(int[]a, int k,int low, int high){
        if(low>high) return false;

        int mid = (low+high)/2;
        if(a[mid]==k){
            return true;
        }
        else if( k > a[mid]){
            return recursive(a, k, mid+1, high);
        }

        return recursive(a, k, low, mid-1);
    }

    public static void main(String[] args) {
        boolean a = recursive(new int[]{3,4,6,7,9,12,16,17},6,0 ,7);
        System.out.println(a);
    }
    
}
