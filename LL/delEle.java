class Node{
    int data;
    Node next;

    Node(){

    }

    Node(Node next1, int data1){
        this.data= data1;
        this.next = next1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}



public class delEle {

    //-------->>>>DELETION IN A LINKED LIST<<<<-----------//




    //------>>>Deletong Head of a LL<<<----------//

    static Node delHead(Node head){
        if(head == null) return null;
        head = head.next;

        return head;
        
    }

    //---->>Deleting Tail of a LL<<---------//

    static Node delTail(Node head){
        Node temp = head;
        if(head == null || head.next == null) return null;

        while(temp.next.next != null){
            temp = temp.next;
            
        }

        temp.next=null;

        return head;
    }

    //---->>> Deleting node at a given Position<<<------//
    static Node delNodeAtPos(Node head ,int k){
        if(head == null) return null;
        if(k==1){
            return head.next;
        }

        int count=0;
        Node prev = null, temp = head;
        while(temp != null){
            count++;

            if(count ==k){
              prev.next = prev.next.next;
              break;  
            }
            prev = temp;
            temp = temp.next;
            
        }

        return head;
    }

    //--------------->>>DEleting node of given value of data<<<<-------------------//
    static Node delNodeAtVal(Node head, int val){
        if(head == null) return head;
        if(head.data == val) return head.next;

        Node temp = head, prev = null;

        while(temp != null){

            

            if(temp.data == val){
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        Node head = new Node(a[0]);
        Node temp = head;

        for(int i=1; i<a.length; i++){
            temp.next = new Node(a[i]);
            temp= temp.next;
        }

        //---->>

       //head = delHead(head);   //delete head

       //head = delTail(head);  //delete tail

       //head = delNodeAtPos(head, 2);

       head = delNodeAtVal(head,2);







        //---->>LL Printing<<------//
        Node mover = head;
        while(mover != null){
            System.out.print(mover.data+" ");
            mover = mover.next;
        }

    }
    
}
