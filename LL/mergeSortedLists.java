class Node{
    int data;
    Node next;
    Node(){}
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}

public class mergeSortedLists {
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


    static Node merge2(Node h1, Node h2){                   //beautiful method....rip apart the nodes and join them in a dummy node
        Node dummy = new Node(-1), temp = dummy;


        Node t1 =h1, t2 = h2, prev =null;

        while(t1 != null && t2 !=null){
            if(t1.data<=t2.data){
                temp.next = t1;
                temp = t1;
                t1= t1.next;
            }
            else{
                temp.next = t2;
                temp= t2;
                t2= t2.next;
            }
        }

        if(t1 != null) temp.next = t1;
        else temp.next = t2;


        return dummy.next;

    }

    public static void main(String[] args) {
        Node h1 = arrtoLL(new int[]{1,2,3});
        Node h2 = arrtoLL(new int[]{4,5});
        Node head = merge2(h2,h1);

        print(head);
    }
}
