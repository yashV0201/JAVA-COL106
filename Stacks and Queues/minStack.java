import java.util.Stack;

class Pair{
    int value;
    int min;

    Pair(int val, int min){
        this.value =val;
        this.min =min;
    }
}

class MStack{
    Stack<Pair> s = new Stack<Pair>();
    int min = Integer.MAX_VALUE;
    int size = 0;

    void push(int x){
        if(x<=min) min =x;
        Pair p = new Pair(x, min);
        s.push(p);
        size++;
    }

    int pop(){
        size--;
        return s.pop().value;
    }

    int top(){
        return s.peek().value;
    }

    int size(){
        return size;
    }

    int getMin(){
        return s.peek().min;
    }
}

public class minStack {
    public static void main(String[] args) {
        MStack st = new MStack();
        st.push(-2);
        st.push(-1);
        System.out.println(st.pop());
        System.out.println(st.top());
    } 
}
