class Node{
    int data;
    Node next;
    Node previous;

    Node(int data1){
        this.data= data1;
        this.next = null;
        this.previous = null;
    }
}


public class doublyLLBasics {
    public static void main(String[] args) {
        int[] a = {2,4,6,8,13,11};
        Node head = new Node(a[0]);

        Node prev = head;
        for(int i=1; i<a.length; i++){
            Node temp = new Node(a[i]);
            temp.previous = prev;
            prev.next = temp;
            prev= temp;

        }

        Node tail = prev;




        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }


    }
    
}
