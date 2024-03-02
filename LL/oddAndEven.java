class Node{
    int data;
    Node next;

    Node(){};
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}


public class oddAndEven {
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

    static Node optimal(Node head){
        Node odd = head, even = head.next, evenHead= head.next;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }




    public static void main(String[] args) {
        Node head = arrtoLL(new int[]{1,6,5,9,4,3});

        head = optimal(head);

        print(head);
    }
}
