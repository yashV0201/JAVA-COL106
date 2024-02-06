import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {

    static int[] hashing(int[]a, int k){
        Map<Integer, Integer> hm = new HashMap<>();
        int n = a.length;

        for(int i =0; i<n; i++){
            if(a[i]<k){
                int rem = k-a[i];
                if(hm.containsKey(rem)){
                    return new int[]{i, hm.get(rem)};
                }
                else if(!hm.containsKey(rem)){
                    hm.put(a[i],i);
                }
            }
            else{
                continue;
            }
        
        }
        return null;


    }
    public static void main(String[] args) {
        int[] a = hashing(new int[]{2,-1,3,5,4,9}, 4);
        System.out.println(Arrays.toString(a));
    
    }
    
}
