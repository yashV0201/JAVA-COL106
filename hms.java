import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class hms {


    static int fact(int n){
        if(n==0){
            return 1;

        }
        else{
            return n*fact(n-1);
        }
    }
    public static void main(String[] args) {
        
        int[] li ={3,5,-2,-3,-6,-6};

        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i =0; i<li.length; i++){
            hm.put(li[i],0);
        }

        for(int i =0; i<li.length; i++){
            hm.put(li[i],hm.get(li[i])+1);
        }

        List<Integer> valuesList = new ArrayList<>(hm.values());

        // Convert the list to an array if needed
        Integer[] arr = valuesList.toArray(new Integer[0]);

        boolean uni = true;

        // Print the array
        for(int i =0; i< arr.length;i++){
            for(int j=i+1; j< arr.length;j++){
                if(arr[i]!=arr[j]){
                    uni = true;
                }
                else {
                    uni = false;
                    break;}

            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(fact(4));
    }
    
}
