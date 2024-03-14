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


    static void print(Node head){            //--->>>>> Prints a LL <<<--------
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static Node delHead(Node head){             //----->>> Deletes Head of a LL <<<<<----------///
        if(head==null || head.next == null) return null;

        head = head.next;
        head.previous = null;

        return head;
    }

    static Node delTail(Node head){            //------>>> Deletes Tail of a LL <<----------//
        if(head==null || head.next == null) return null;

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.previous.next = null;
        temp.previous  = null;


        return head;
    }

    static Node delAtPos(Node head, int k){           //------>> Deletes Element at a given Position <<<-----///
        if(head == null) return null;
        
        int count =0;
        Node temp = head;
        while( temp != null){
            count++;
            if(count == k){
                break;
            }

            temp = temp.next;
        }

        if(temp == null) return head;          // if k is greater than number of elements..then temp becomes null..in that case no element is to be deleted

        Node front = temp.next, back = temp.previous;    //checking for next and previous elements

        if(front == null && back == null){
            return null;

        }

        else if(back == null){
            front.previous = null;
            head= front;
            front = null;
        }
        
        else if(front == null){
            back.next = null;
            back = null;
        }

        else{
            back.next = front;
            front.previous = back;
            front = null;
            back = null;
        }

        return head;

    }
    static Node delOcc(Node head, int k){
        Node temp =head;
        while(temp != null){
           if(temp.data ==k){
               if(temp.previous == null){
                   head.next.previous = null;
                   head = head.next;
                   temp = temp.next;
               }
               else if(temp.next == null){
                   temp.previous.next = null;
                   temp.previous = null;
                   temp = temp.next;
               }
               else{
                   temp.previous.next = temp.next;
                   temp.next.previous= temp.previous;
                   temp.previous = null;
                   temp = temp.next;

               }
            }
            else temp = temp.next;
        }

        return head;
    }


    public static void main(String[] args) {
        int[] a = {10,2,4,6,10,13,10};
        Node head = new Node(a[0]);

        Node prev = head;  
        for(int i=1; i<a.length; i++){
            Node temp = new Node(a[i]);
            temp.previous = prev;
            prev.next = temp;
            prev= temp;

        }

        Node tail = prev;

        //head = delHead(head);
        //head = delTail(head);
        //head = delAtPos(head, 1);
        head = delOcc(head, 10);


        print(head);


    }
    
}
