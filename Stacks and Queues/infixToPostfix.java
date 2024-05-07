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
        Stack<Character> st = new Stack<>();
        for(char ch : exp.toCharArray()){
            if(Character.isLetterOrDigit(ch)) ans+=ch;
            else{
                if()
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(optimal(s));
    }
}
