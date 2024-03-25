import java.util.ArrayList;
import java.util.Arrays;

public class comibnationSum {
    static void combSum(int[] arr, int index, int k, int sum, ArrayList<Integer> list){
        
        //base case
        if(sum == k){
            System.out.print(list.toString()+" ");
            return;
        }

        if(sum>k || index == arr.length) return;
        //base case ends

        //numbers can also repeat...so when choosing a number it can be choswn multiple times..so do not increase the index
        list.add(arr[index]);
        sum+=arr[index];
        combSum(arr, index, k, sum, list);

        // when not choosing the number, change the index ot next
        list.remove(list.size()-1);
        sum -= arr[index];
        combSum(arr, index+1, k, sum, list);
    }

    static void combSum2(int[] arr, int index, int k, int sum, ArrayList<Integer> list){  //very complex
        Arrays.sort(arr);                                           
        if(sum == k){
            System.out.print(list.toString()+" ");
            return;
        }

        for(int i = index; i<arr.length;i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[i]>k) break;

            list.add(arr[i]);
            sum+=arr[i];
            combSum2(arr, i+1, k, sum, list);

            list.remove(list.size()-1);
            sum-=arr[i];
        }   
        
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2,5,2};
        ArrayList<Integer> list = new ArrayList<>();

        combSum2(arr, 0, 5, 0, list);
    }
}
