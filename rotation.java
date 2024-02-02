import java.util.Arrays;

public class rotation {

    static int[] rotateByK1(int[] arr, int k){  //rotate left

        int n = arr.length;
        k = k%n;
        int[] temp = new int[k];
        for(int i =0; i<k; i++){
            temp[i]=arr[i];
        }
        for(int i = k; i<n; i++){
            arr[i-k] = arr[i];
        }
        for(int i = n-k; i<n; i++){
            arr[i] = temp[i-n+k];
        }

        return arr;
    }
    static int[] rotateByKR(int[] arr, int k){  //rotate right

        int n = arr.length;
        k = k%n;
        int[] temp = new int[k];
        for(int i =n-k; i<n; i++){  //transfering elements to temp
            temp[i-n+k]=arr[i];
        }
        for(int i = n-1; i>=k; i--){
            arr[i] = arr[i-k];
        }
        for(int i = 0; i<k; i++){
            arr[i] = temp[i];
        }

        return arr;
    }

    static void reverse(int[] arr , int low, int high){
        if(low == high) return;
        else{
            int start = low;
            int end = high;
            while(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }

    static int[] rotateByK2(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;
        reverse( arr, low, k-1);
        reverse(arr, k, high);
        reverse(arr, low, high);

        return arr;
    }

    public static void main(String[] args) {
        int[] a = rotateByK1(new int[]{2,3,4,5,6}, 2);
        int[] b = rotateByKR(new int[]{2,3,4,5,6}, 2);
        int[] c = rotateByK2(new int[]{2,3,4,5,6}, 2);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
    
}
