class Stack{
    int size = 1000;
    int[] arr = new int[size];
    int top = -1;

    public void push(int a){
        top++;
        arr[top] = a;
    }

    int pop(){
        int x = arr[top];
        top--;
        return x;
    }

    int top(){
        return arr[top];
    }

    int size(){
        return top+1;
    }
}

class Queue{
    int[] arr = new int[5];
    int front = 0, rear =0,count = 0;

    void push(int x){
        if(rear-front<arr.length){
            arr[rear%arr.length] = x;
            rear++;
            count++;
        }else System.out.println("Queue full:Can't push "+x);
    }

    int pop(){
        if(count == 0) return -1;
        int ret = front%arr.length;
        front++;
        count--;
        return arr[ret];
    }

    int top(){
        if(count==0) return -1;

        return arr[front%arr.length];
    }
}




public class intro{
    
    public static void main(String[] args) {
        Stack s = new Stack();
        // s.push(1);
        // s.push(3);
        // System.out.println(s.top());

        Queue q = new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        
        System.out.println(q.pop());
        q.push(6);
        System.out.println(q.pop());
        q.push(7);
        q.push(8);
        System.out.println(q.top());
    }
}