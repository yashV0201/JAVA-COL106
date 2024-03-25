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

    public static void main(String[] args) {
        int arr[] = {3,1,2};
        ArrayList<Integer> list = new ArrayList<>();

        subSum(arr, 0, 0, list);
    }
}
