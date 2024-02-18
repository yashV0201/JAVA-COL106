public class minInRotatedArray {
    static int optimalSelf(int[]a){     // observation: ans always lies in unsorted half
        int low =0, high = a.length-1, min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]<=min) min = a[mid];
             
            //left half unsorted.....so eliminate right half
            if(a[mid]<a[low] && a[high]>=a[mid]){
                high = mid-1;

            }
            //right half unsorted.....so eliminate elft half
            if(a[mid]>=a[low] && a[high]<a[mid]){
                low = low+1;

            }

            else //if(a[mid]>=a[low] && a[mid]<=a[high]){  //both sorted...then work normally...i.e. move towrds smaller elements
                {
                high = mid-1;
            }

        }

        return min;
    }

    public static void main(String[] args) {
        int a = optimalSelf(new int[]{6,7,8,9,10,0,1,2,3,4});
        System.out.println(a);
    }
    
}
