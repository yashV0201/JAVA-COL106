class Node{
    int data;
    Node next;
    Node(){}
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}



public class sort {
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
        Node fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    static Node merge2(Node h1, Node h2){                   //beautiful method....rip apart the nodes and join them in a dummy node
        Node dummy = new Node(-1), temp = dummy;


        Node t1 =h1, t2 = h2, prev =null;

        while(t1 != null && t2 !=null){
            if(t1.data<=t2.data){
                Node next = t1.next;
                temp.next = t1;
                t1.next = null;
                temp = t1;
                t1= next;
            }
            else if(t2.data <= t1.data){
                Node next = t2.next;
                temp.next = t2;
                t2.next = null;
                temp= t2;
                t2= next;
            }
        }

        if(t1 != null) temp.next = t1;
        if(t2 != null) temp.next = t2;


        return dummy.next;

    }

    static Node merge(Node h1, Node h2){
        Node t1= h1, t2=h2;
        Node dummy = new Node(-1), temp = dummy;

        while(t1 != null && t2!=null){
            if(t1.data<=t2.data){
                Node n = new Node(t1.data);
                temp.next = n;
                temp = temp.next;
                t1 = t1.next;
            }

            else if(t2.data<= t1.data){
                Node n = new Node(t2.data);
                temp.next = n;
                temp = temp.next;
                t2 = t2.next;
            }    
        }
        while(t1 != null){
            Node n =new Node(t1.data);
            temp.next = n;
            temp = temp.next;
            t1 = t1.next;
        }

        while(t2 != null){
            Node n =new Node(t2.data);
            temp.next = n;
            temp = temp.next;
            t2 = t2.next;
        }


        return dummy.next;
    }

    static Node sorted(Node head){
        if(head==null || head.next == null) return head;
        Node mid = mid(head);
        Node leftHead = head, rightHead = mid.next;
        mid.next = null;


        leftHead = sorted(leftHead);
        rightHead = sorted(rightHead);
        head = merge(leftHead, rightHead);


        return head;
    }

    public static void main(String[] args) {
        Node h1 = arrtoLL(new int[]{1,2,3});
        Node h2 = arrtoLL(new int[]{4,5});
        Node h3 = arrtoLL(new int[]{1,4,6,7,3,4,2,5});

        Node head = merge2(h2,h1);
        Node head2 = sorted(h3);

        print(head2);
    }
}
