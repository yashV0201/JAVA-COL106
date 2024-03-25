import java.util.ArrayList;

public class subsetSum {
    static void subSum(int[] arr, int index, int sum, ArrayList<Integer> list){
        if(index >= arr.length){
            System.out.print(sum+" ");
            return;
        }

        //case pick
        list.add(arr[index]);
        sum+=arr[index];
        subSum(arr, index+1, sum, list);

        list.remove(list.size()-1);
        sum-=arr[index];
        //case not pick
        subSum(arr, index+1, sum, list);

    }

    static void subset(int[] arr, int index,  ArrayList<Integer> list){
        
        System.out.print(list.toString()+" ");

        for(int i=index; i<arr.length; i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            
            subset(arr, i+1, list);

            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        int arr[] = {1,2,2,3};
        ArrayList<Integer> list = new ArrayList<>();

        subset(arr, 0, list);
    }
}
