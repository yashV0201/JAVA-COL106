import java.util.Arrays;

public class rearngeBySign {
    static void bruteArr(int[] a){
        int n = a.length;
        int j = 0;
        for(int i =0; i<n; i++){
            if(j<n-1 && a[i]*a[j]<0){
                //if(a[j+1]*a[i]<0){
                    j++;
                    int temp = a[i];
                    a[i] =a[j];
                    a[j] = temp;
               // }

            }
            else continue;

        }
    }
    static int[] Optimal(int[]a){       //even places occupied by positive nos. & odd places occupied by negative nos.
        int n = a.length;
        int pos=0;                      // starting point for positive nos.
        int neg =1;                    // starting point for negative nos.
        int arr[] = new int[n];
        for(int i= 0; i<n; i++){
            if(a[i]>0){
                arr[pos] = a[i];
                pos+=2;
            }

            else if(a[i]<0){
                arr[neg] = a[i];
                neg+=2;
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        int[] a = Optimal(new int[]{1,2,-3,4,-6,-7});
        System.out.println(Arrays.toString(a));
    }
}
