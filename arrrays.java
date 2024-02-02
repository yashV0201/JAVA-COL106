import java.util.Arrays;
import java.util.Scanner;

public class arrrays {

    static int[] Insert(int arr[], int pos, int key){

        int end= arr.length -1;


            for(int i=end; i>pos; i--){
                arr[i]=arr[i-1];

            }
            arr[pos] = key;

        return arr;
    }

    static int[] Delete(int arr[], int pos){

        int end= arr.length -1;


            for(int i=pos; i<end; i++){
                arr[i]=arr[i+1];

            }

           arr[end]=0;   
            

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[10];

        Scanner sc = new Scanner(System.in);

        for(int i =0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        Insert(arr, 3, 16);

        System.out.println(Arrays.toString(arr));

        Delete(arr, 3);

        System.out.println(Arrays.toString(arr));
        
    }
    
}
