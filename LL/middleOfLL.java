class Node{
    int data;
    Node next;

    Node(){};
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}



public class middleOfLL {
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

    static Node mid(Node head){
        if(head == null) return head;
        Node mid = head, tail = head;
        int count = 1;
        while(tail != null){
            if(count%2==0){
                mid = mid.next;
            }

            count++;
            tail = tail.next;
        }

        return mid;
    }

    public static void main(String[] args) {
        Node head = arrtoLL(new int[]{2,3,5,9,7});

        Node mi = mid(head);

        print(mi);
    }
    
}
