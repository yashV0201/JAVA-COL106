import java.util.List;
import java.util.ArrayList;

public class combinationSum3 {
    static void combSum(int n,int k,int index, int i, int sum, List<List<Integer>> ans,List<Integer>list){
        if(sum>k) return;
        if(index == n){
            if(sum==k){
                //System.out.print(list.toString());
                List<Integer> temp = new ArrayList<>();
                for(Integer ele:list){
                    temp.add(ele);
                }
                ans.add(temp);
        
            }
            return;
        }
        
        for(int j = i; j<=9;j++){
            sum+=j;
            list.add(j);
            combSum(n, k, index+1, j+1, sum, ans, list);

            sum-=j;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combSum(2, 5, 0,1, 0, ans, list);
        for(List<Integer> ele:ans){
           System.out.print(ele.toString()+" ");
        };

    }
}
