import java.util.List;
import java.util.ArrayList;

public class palindromePartitioning {
    static boolean checkPalindrome(String s){
        int i =0,j=s.length()-1;
        boolean ans = true;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return ans;
    }

    static void partitioning(int index,String s,List<String> list, List<List<String>> ans ){
        if(index == s.length()){
            System.out.print(list.toString()+" ");
            return;
        }

        for(int i = index; i<s.length();i++){
            if(checkPalindrome(s.substring(index,i+1))){
                list.add(s.substring(index,i+1));
                partitioning(i+1, s, list, ans);
                list.remove(list.size()-1);
            }
        }
        

    }

    public static void main(String[] args) {
        String s = "aabb";
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        partitioning(0, s, list, ans);
    }
}
