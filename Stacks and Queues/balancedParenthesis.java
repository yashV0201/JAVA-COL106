class Stack{
    int size = 1000;
    Character[] arr = new Character[size];
    int top = -1;

    public void push(char a){
        top++;
        arr[top] = a;
    }

    char pop(){
        char x = arr[top];
        top--;
        return x;
    }

    char top(){
        return arr[top];
    }

    int size(){
        return top+1;
    }
}

public class balancedParenthesis {
    static boolean optimal(Stack s, String str){
        String open = "([{";
        String close = ")]}";
        for(int i =0; i<str.length();i++){
            if(open.contains(str.substring(i,i+1))){
                s.push(str.charAt(i));
                
            }
            else if(close.contains(str.substring(i,i+1))){
                char ch = str.charAt(i);
                char st = open.charAt(close.indexOf(str.substring(i,i+1)));
                if(s.size() !=0 && st == s.top()){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.size() != 0) return false;


        return true;
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        
        boolean ans = optimal(s,"{}()");
        System.out.println(ans);
    }
}
