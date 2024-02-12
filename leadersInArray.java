import java.util.ArrayList;
import java.util.Arrays;

public class leadersInArray {
    static int[] optimal(int[]a){
        int n = a.length;
        int max= a[n-1];
        ArrayList<Integer> li = new ArrayList<>();
        for(int i=n-2;i>=0; i--){
            if(a[i]>max){
                max = a[i];
                li.add(max);

            }

        }
        int[] ans = new int[li.size()];
        int i=li.size()-1;
        for(int ele: li){
            ans[i] =ele;
            i--;

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = optimal(new int[]{10,22,12,3,0,6});

        System.out.println(Arrays.toString(a));
    }
    
}
