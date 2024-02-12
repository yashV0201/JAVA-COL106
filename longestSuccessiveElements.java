import java.util.HashSet;
import java.util.Set;

public class longestSuccessiveElements { 

    

    public static int Optimal(int[]a){   //using Set Data Structure

        int n = a.length;
        if(n==0) return 0;

        Set<Integer> set = new HashSet<>();
        int cnt = 1;
        for(int i = 0; i<n; i++){
            set.add(a[i]);
        }

        int longest = 1;
        for(int ele: set){
            if( !set.contains(ele-1)){
                cnt = 1;
                int x= ele;
                while(set.contains(x+1)){
                    x = x+1;
                    cnt++;
                }

                longest = Math.max(cnt, longest);

            }

        }

        return longest;
        
    }

    public static void main(String[] args) {
        int a = Optimal(new int[]{100,200,1,3,4,5,8,9,6,7,2});
        System.out.println(a);
    }
    
}
