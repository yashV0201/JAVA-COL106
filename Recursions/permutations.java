import java.util.ArrayList;
import java.util.Arrays;


public class permutations {
    static void printPerm(int[] arr, int index, ArrayList<Integer> list){
        if(index == arr.length){
            System.out.print(list.toString()+" ");
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(list.contains(arr[i])) continue;
            list.add(arr[i]);
            printPerm(arr, index+1, list);
            list.remove(list.size()-1);
        }
    }

    static void swap(int[] arr,int a, int b){
        int temp =arr[a];
        arr[a]=arr[b];
        arr[b] = temp;
    }

    static void printPerm2(int[] arr, int index, ArrayList<Integer> list){
        if(index == arr.length){
            System.out.print(Arrays.toString(arr)+" ");
            return;
        }
        for(int i = index;i<arr.length;i++){
            swap(arr, index,i);
            printPerm2(arr, index+1, list);
            swap(arr,index,i);
        }
    }

    public static void main(String[] args) {
        int[] arr= {1,2,3};
        ArrayList<Integer> list = new ArrayList<>();

        printPerm2(arr, 0, list);
    }
}
