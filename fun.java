import java.util.ArrayList;

public class fun {
    
    public static void main(String[] args) {
        String[] fileNames = {"a.java","Ganduuu.java"};
        String a = new String();
        ArrayList<String> arr = new ArrayList<>();

        for(int i =0; i<fileNames.length;i++){
            StringBuilder str = new StringBuilder();
            for(int j = fileNames[i].length()-1;j>=fileNames[i].length()-5;j--){
                
                char ch = fileNames[i].charAt(j);
                str.append(ch);
                a = str.toString();

            }
            
    
    
    
        }

        if(a.equals("avaj.")){
            System.out.println(a);
        }
        else{
            System.out.println("lol");
        }
    }
    
}
