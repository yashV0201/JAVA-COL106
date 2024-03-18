class Node{
    int data;
    Node next;

    Node(){}
    Node(int data1){
        this.data = data1;
        this.next = null;

    }
}


public class removeDuplicates {
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
        Node curr = head, temp = head.next;
        while(temp != null){
            
            while(temp != null && temp.data == curr.data){
                temp = temp.next;
            }

            curr.next = temp;
            curr = temp;
            if(temp != null)temp = temp.next;
        }

        return head;

    }

    public static void main(String[] args) {
        Node head= arrtoLL(new int[]{1,1,1,2,2,3,4,4});

        head = optimal(head);

        print(head);
    }
}
