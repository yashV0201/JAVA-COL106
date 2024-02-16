import java.util.*;

public class ThreeSum {

    static List<List<Integer>> brute(int[]a){
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<a.length; i++){
            int k = 0 - a[i];
            
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int j=i+1; j<a.length; j++){
                
                int res = a[j]-k;
                if(hm.containsKey(res)){
                    List<Integer> li = new ArrayList<>();
                    li.add(a[i]);
                    li.add(a[j]);
                    li.add(res);
                    ans.add(li);
                }
                else{
                    hm.put(a[j],j);
                }

            }

            
        }





        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> a = brute(new int[]{-1,0,1,2,-1,-4});

        System.out.println(a.get(0).get(2));
    }
    
}
