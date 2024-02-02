import java.util.HashMap;

public class exercise20{
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        int m =3;
        int n =0;
        String ret = "";

        HashMap<String, int> hm = new HashMap<String, int>();

		StringBuilder str = new StringBuilder();
        
        for(int i =m;i<s1.length(); i++){
            str.append(s1.charAt(i));
        }

		for(int i =0; i<=n; i++){
			str.append(s2.charAt(i));

		}


		ret = str.toString();

        System.out.println(ret);
    }
}