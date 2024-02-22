import java.util.ArrayList;
import java.util.Arrays;

public class rowMaxOnes {

    static int optimal(ArrayList<ArrayList<Integer>> mat, int n, int m){

        int minIndex= m, ans = -1;
        for(int i =0; i<n; i++){
            
            int low = 0, high = m-1, index = m;
            while(low<=high){
                int mid= (low+high)/2;
                if(mat.get(i).get(mid)<1){
                    low = mid+1;
                }
                else{
                    index = mid;
                    high = mid-1;
                }
            }

            if(index<minIndex){
                minIndex = index;
                ans = i;
            }   

        }

        return ans;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        arr.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        arr.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int a= optimal(arr,3,3);
        System.out.println(a);
    }
    
}
