public class reverseWords {
    static String reverse(String s){
        s = s.trim();
        int end = s.length()-1;
        StringBuilder ans = new StringBuilder();
        while(end>=0){
            int start = end;
            if(s.charAt(start) == ' '){
                end--;
                continue;
            }
            
            while(start>=0 && s.charAt(start) != ' '){
                start--;
            }
            ans.append(s.substring(start+1, end+1));
            ans.append(' ');

            end = start;


        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "   cats and   dogs";

        System.out.println(reverse(s));
    }
    
}
