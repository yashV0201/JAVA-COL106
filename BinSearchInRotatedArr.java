public class BinSearchInRotatedArr {
    static int incorrect(int[]a, int k){
        int low =0, high = a.length-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(a[mid] == k) return mid;
            else if(a[mid]<k && k>a[high]){
                high = mid-1;
            }
            else if(a[mid]<k && k<=a[high]){
                low = mid+1;
            }

            else if(a[mid]>k && k<a[high]){
                low = mid+1;
            }


            else if(a[mid]>k && k>=a[high]){
                high = mid-1;
            }

        }

        return -1;
    }

    static int optimalSelf(int[]a, int k){     //did with a very small hint
        int low =0, high = a.length-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(a[mid] == k) return mid;
            else{
                if(a[mid]<a[low]){
                    if(k>a[mid] && k<=a[high]){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
                else if(a[mid]>a[high]){
                    if(k<a[mid] && k>=a[low]){
                        high = mid-1;
                    }
                    else{
                        low = mid +1;
                    }
                }

                else{
                    if(a[mid]==k) return mid;
                    else if(a[mid]<k){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }

            }
            
        }
        return -1;
    }

    static int optimal(int[]a, int k){
        int low =0, high = a.length-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(a[mid] == k) return mid;
            //checking if left half sorted

            if(a[low]<=a[mid]){
                // yes, left half is sorted
                if(k>=a[low] && k<=a[mid]){  //checking if target lies in sorted part
                    //yes it does...so we eliminate the unsorted part
                    high = mid-1;
                }
                else{
                    // no it doesn't...so we eliminate the unsorted part
                    low = mid+1;
                }
            }

            else{
                //no, right part is sorted
                if(k<=a[high] && k>=a[mid]){//checking if target lies in sorted part
                    //yes it does...so we eliminate the unsorted part
                    low = mid+1;
                }
                else{
                    // no it doesn't...so we eliminate the unsorted part
                    high = mid-1;
                }

            }
        }
        return -1;

    }

    public static void main(String[] args) {
        

        for(int i =0; i<=12; i++){
            int a = optimalSelf(new int[]{4,5,6,7,8,9,10,11,0,1,2,3},i);
            System.out.print(a+" ");
        }
        System.out.println();

        for(int i =0; i<=12; i++){
            int a = optimal(new int[]{4,5,6,7,8,9,10,11,0,1,2,3},i);
            System.out.print(a+" ");
        }
        
    }
    
}
