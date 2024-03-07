class Node{
    int data;
    Node next;
    Node(){}
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}


public class sort0s1s2s {
    
    static Node arrtoLL(int[] a){
        Node head = new Node(a[0]);
        Node temp = head;
        for(int i=1; i<a.length; i++){
            Node newest = new Node(a[i]);
            temp.next = newest;
            temp = temp.next;
        }

        return head;
    }

    static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp =temp.next;
        }
    }

    static Node sort(Node head){
        Node d1 = new Node(-1), d2= new Node(-1), d3=new Node(-1);
        Node t1 = d1, t2=d2, t3=d3;
        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                Node next = temp.next;
                t1.next = temp;
                t1 = temp;
                temp.next = null;
                temp =next;
            }else if(temp.data == 1){
                Node next = temp.next;
                t2.next = temp;
                t2 = temp;
                temp.next = null;
                temp =next;
            }else{
                Node next = temp.next;
                t3.next = temp;
                t3 = temp;
                temp.next = null;
                temp =next;
            }
        }

        t1.next = d2.next !=null ? d2.next: d3.next;     //This line is using the ternary conditional operator (? :). It's a shorthand way of writing an if-else statement.
        
        t2.next = d3.next;

        return d1.next;
    }

    

    public static void main(String[] args) {
        Node head = arrtoLL(new int[]{1,2,0,1,0,0,1,2,2,1});

        head = sort(head);

        print(head);
    }
}
