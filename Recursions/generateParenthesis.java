import java.util.ArrayList;

public class generateParenthesis {
    static void generate(int n,int left, int right, int index,ArrayList<String> list, String s){
        if(right<left) return;
        if(index == n){
            list.add(s);
            return;
        }
        
        if(left>0)generate(n,left-1, right,index+1, list, s+'(');
    
        
        if(right>0)generate(n,left,right-1,index+1,list,s+')');
    }
    static void generate2(int left, int right,ArrayList<String> list, String s){
        //if(right<left) return;
        if(left==0 && right==0){
            list.add(s);
            return;
        }
        
        if(left>0)generate2(left-1, right+1, list, s+'(');
    
        
        if(right>0)generate2(left,right-1,list,s+')');
    }

    public static void main(String[] args) {
        ArrayList<String> list =new ArrayList<>();
        int n =3;
        generate(2*n,n, n,0, list,"");

        System.out.println(list.toString());
    }
}
