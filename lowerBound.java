public class lowerBound {

    static int ceiling(int[]a, int k){
        int low =0, high = a.length-1;
        int ans = a.length;
        while(low<=high){
            int mid =(low+high)/2;
            if(a[mid]==k){
                int b = mid;
                if(a[b]==a[b-1]){
                   while(a[b]==a[b-1]){
                    b--;
                    ans = b;
                   } 
                   return ans;
                }
                else return mid;
                
            }

            else if(a[mid]>k){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }

        }

        return ans;
    }

    static int lowerB(int[]a, int k){           //Ossumm algo maaann...!!
        int low =0, high = a.length-1, ans = a.length;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]>= k){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int lb = lowerB(new int[]{1,2,3,4,6,6,6,6,8,9,10},5);
        System.out.println(lb);
    }
    
}
