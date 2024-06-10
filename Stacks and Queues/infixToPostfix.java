import java.util.Stack;

public class infixToPostfix {
    static int Prec(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;
            
            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }

        return -1;
    }
    static String optimal(String exp){
        String ans = "";
        Stack<Character> st = new Stack<>();
        for(char ch : exp.toCharArray()){
            if(Character.isLetterOrDigit(ch)) ans += ch;
            else if(ch == '(') st.push(ch);
            else if( ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans += st.peek();
                    st.pop();
                }st.pop();
            }
            else{
                while(!st.isEmpty() && Prec(ch)<=Prec(st.peek())){
                    ans += st.pop();
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }

    static String postfixToInfix(String exp){
        String ans = "";

        Stack<String> st = new Stack<>();
        for(int i = exp.length()-1;i>=0;i--){
            ans+=exp.charAt(i);
        }
        exp = ans;
        ans = "";
        
        for(char ch : exp.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                String temp = ""+ch;
                st.push(temp);
            }
            else{
                ans = "("+st.pop()+ch+st.pop()+")";
                st.push(ans);
            }
        }

        ans = st.pop();
        return ans; 
    }


    public static void main(String[] args) {
        String s = "a+b-c";
        System.out.println(optimal(s));
        System.out.println(postfixToInfix("/-ab+-cde"));
    }
}
