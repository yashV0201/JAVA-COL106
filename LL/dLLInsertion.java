class Node{
    int data;
    Node next;
    Node previous;

    Node(){

    }

    Node(int data1){
        this.data = data1;
        this.next = null;
        this.previous = null;

    }

    Node(int data1, Node nex, Node prev){
        this.data = data1;
        this.next = nex;
        this.previous = prev;
    }
}






public class dLLInsertion {

    static Node arrToDLL(int[]a){
        Node head = new Node(a[0]);
        Node prev = head;
        for(int i=1; i<a.length; i++){
            Node temp = new Node(a[i]);
            temp.previous = prev;
            prev.next = temp;
            prev = prev.next;
        }

        return head;
    }

    static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static Node insHead(Node head, int val){
        if(head == null) return new Node(val);
        
        Node temp = new Node(val);
        temp.next = head;
        head.previous= temp;
        head = temp;


        return head;
    }

    static Node insTail(Node head, int val){
        if(head == null) return new Node(val);
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        Node temp = new Node(val);
        tail.next= temp;
        temp.previous = tail;
        tail = tail.next;


        return head;
    }

    static Node insAtPos(Node head, int val, int k){
        Node temp = head;
        Node tail = temp;
        int count = 0;
        while( temp != null){
            count++;
            if(count == k){
                break;
            }
            if(temp.next==null){
                tail = temp;
            }
            temp = temp.next;
        }

        count++;                //not necessary

        if(temp == null){
            if(count == k){/////////////////////////////
                Node front = new Node(val);
                front.previous = tail;            /////// NOT NECESSARY
                tail.next = front;
                tail = front;/////////////////////////////

                return head;

            }
            return head;
        }
        

        else if(temp.previous == null){
            Node back = new Node(val);
            back.next = temp;
            temp.previous = back;
            head = back;
        }
        else{
            Node front = new Node(val);
            temp.previous.next =front;
            front.previous = temp.previous;
            front.next = temp;
            temp.previous = front;
        }

        return head;
        
    }


    public static void main(String[] args) {
        
        Node head = arrToDLL(new int[]{2,3,4,5,7,9,11,10});

        head = insHead(head, 0);
        head = insTail(head, 12);
        head = insAtPos(head, 15, 1);

        print(head);
    }

    
}
