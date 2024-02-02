import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class sorting {

    static int f(int[] arr , int low, int high){
        int pivot = low;
        int i = low;
        int j = high;

        while(i<j){
            while( arr[i]<=arr[pivot] && i<= high-1){
                i++;
            }
            while(arr[j]> arr[pivot] && j>= low+1){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;

        return j;
        

    }

    static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int part = f(arr, low, high);
            quickSort(arr , low, part-1);
            quickSort(arr, part+1, high);
        }
    }

    static void sort(int[] arr,int low, int mid, int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;

            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;

        }
        while(right<=high){
            temp.add(arr[right]);
            right++;

        }

        for(int i = low; i<=high; i++){
            arr[i] = temp.get(i - low);
        }


        

    }

    static void mergeSort(int[] arr, int low, int high ){
        if(low == high){
            return;
        } 

        else{
            int mid = (low+high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            sort(arr,low, mid, high);

        }




        

    }

    static void bubble_sort(int[] arr){
        int n = arr.length;

        for(int i =n-1; i>0; i--){
            for(int j = 0; j<i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }


        }
    }

    static void seletion_sort1(int[] arr){   // self-coded
        int n  = arr.length;
        for(int i =0; i<n; i++){
            for(int j =0; j<=i;j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] =temp;
                }
            }
        }

    }

    static void selection_sort(int[] arr){
        int n  = arr.length;
        for(int i =0; i<n; i++){
            int j =i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] =temp;

                j--;
            }
            

        }

    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(10);

        



        int[] arr = {2,5,4,8,6,11,15,9,7};
        int[] arr1 ={3,1,2};

        int[] hash = new int[123];

        

        /* for(int i =0; i< arr.length;i++){
            int temp;
            int s = i;
            for(int j=i; j<arr.length; j++){
                if(arr[j]<arr[s]){
                    s = j;
                    
                }
            }
            temp = arr[s];
            arr[s]= arr[i];
            arr[i]= temp;
        } */

        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));

        
        
    }
    
}
