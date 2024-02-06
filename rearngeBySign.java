import java.util.Arrays;

public class rearngeBySign {
    static void bruteArr(int[] a){
        int n = a.length;
        int j = 0;
        for(int i =0; i<n; i++){
            if(j<n-1 && a[i]*a[j]<0){
                j++;
                int temp = a[i];
                a[i] =a[j];
                a[j] = temp;

            }
            else continue;

        }
    }
    
    public static void main(String[] args) {
        int[] a ={1,2,-3,4,-6,-7};
        bruteArr(a);
        System.out.println(Arrays.toString(a));
    }
}
