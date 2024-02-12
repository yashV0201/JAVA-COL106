import java.util.Arrays;

public class nextPermutation {

    static void swap(int n, int m , int[]a){
        int temp = a[n];
        a[n]=a[m];
        a[m] = temp;

    }
    static void reverse(int index, int[]a){
        int lim = (a.length-index)/2;
        int i = 0;
        while(i<lim){
            swap(index+i,a.length-1-i,a);
            i++;
        }
    }
    static void optimal(int[]a){
        int n = a.length;
        int ind = -1;
        for(int i =n-2; i>=0; i--){
            if(a[i]<a[i+1]){
                ind = i;
                break;
            }
        }
        if(ind ==-1){
            reverse(0, a);
            
        }

        else{
            for(int i =n-1; i>ind; i--){
                if(a[i]>a[ind]){
                swap(ind, i, a); 
                break;
                }
            }
            reverse(ind+1,a);
        }
        




    }
    public static void main(String[] args) {
        int[] a ={4,3,1,2};
        optimal(a);
        System.out.println(Arrays.toString(a));
    }
    
}
