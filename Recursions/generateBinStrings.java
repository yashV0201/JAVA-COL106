import java.util.ArrayList;
import java.util.List;

public class generateBinStrings {
    static void generate(int index,int n, List<String> list, String s){
        if(index == n){
            list.add(s);
            return;

        }
        
        s+='0';
        generate(index+1, n, list, s);
        s = s.substring(0,s.length()-1);
        if(index==0 || s.charAt(index-1) != '1'){
            s+='1';
            generate(index+1, n, list, s);
        }
        
    }

    public static void main(String[] args) {
        int n = 4;
        List<String> list = new ArrayList<>();
        generate(0, n, list, "");
        System.out.println(list.toString());
        
    }
}
