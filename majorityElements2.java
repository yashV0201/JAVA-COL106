import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majorityElements2 {     // if element is present for more than n/3 times


    static List<Integer> brute(int[]a){                 //---|| TC:O(N*N)  SC:O(1)

        List<Integer> li = new ArrayList<>();
        for(int i=0; i<a.length; i++){

            if(li.size()==0 || li.get(0) != a[i]){
                int cnt=0;
                for(int j =0; j<a.length; j++){
                    if(a[i]==a[j]) cnt++;

                }

                if(cnt> a.length/3 ){
                    li.add(a[i]);
                }
            }

           if(li.size()==2) break; 
            
        }



        return li;
    }

    static List<Integer> better(int[]a){
        List<Integer> li = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i =0; i<a.length; i++){
            mp.put(a[i], mp.getOrDefault(a[i],0)+1);
        }

        for(int i=0; i<a.length; i++){
            if(li.size()==0 || li.get(0) != a[i]){
                if(mp.get(a[i])> a.length/3){
                    li.add(a[i]);
                }

                if(li.size()==2) break;
            }
            
        }

        return li;
    }
    
    
    static List<Integer> Optimal(int[]nums){    // TC: O(N) SC:O(1)
        
        int n = nums.length;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int cnt1=0, cnt2=0;
        for(int i=0; i<n; i++){
            if(cnt1==0 && nums[i] != ele2){
                cnt1=1;
                ele1= nums[i];
            }
            else if(cnt2==0 && nums[i] != ele1){
                cnt2=1;
                ele2= nums[i];
            }
            else if(nums[i]==ele1) cnt1++;
            else if(nums[i]==ele2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> li = new ArrayList<>();
        cnt1 =0; cnt2 =0;

        for(int i =0; i<n; i++){
            if(nums[i]==ele1) cnt1++;
            if(nums[i]==ele2) cnt2++;
        }

        if(cnt1>(n/3)) li.add(ele1);
        if(cnt2>(n/3)) li.add(ele2);

        return li;
        
    }

    


    public static void main(String[] args) {
        List<Integer> a = Optimal(new int[]{1,8,5,5,8,8,8,5,5});
        System.out.println("aaaa");
        
        for(int i=0; i< a.size(); i++){
            
            System.out.print(a.get(i)+" ");
        }
    }
    
}
