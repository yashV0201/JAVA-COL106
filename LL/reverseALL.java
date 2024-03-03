class Node{
    int data;
    Node next;

    Node(){}

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}




public class reverseALL {
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

    static Node optimal(Node head){                         /// Self thought...adding a new node before head with values of nodes as traversed
        if(head == null || head.next == null) return head;
        Node tail = head.next, end = head;
        while(tail != null){
            Node temp = new Node(tail.data);
            temp.next = head;
            head = temp;
            tail = tail.next;
        }

        end.next = null;

        return head;
    }

    static Node optimal2(Node head){                     /// changing the links method
        if(head==null || head.next == null) return head;
        Node prev = null, temp = head;
        while(temp.next != null){
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        temp.next = prev;

        return temp;
    }

    public static void main(String[] args) {
        Node head = arrtoLL(new int[]{2,3,4,5,6});

        head = optimal2(head);

        print(head);
    }
}
