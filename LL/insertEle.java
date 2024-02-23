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




public class insertEle{

//----------==>> INSERTING ELEMENT IN A LL <<==---------//



//-------->>>Inserting element at HEAD<<<--------------//
    static Node insertHead(Node head, int val){
        Node newest = new Node(val);
        newest.next = head;
        head = newest;


        return head;
    }



//------>>>> INSERTING ELEMENTS AT TAIL<<<<<-------------//
    static Node insertTail(Node head, int val){

        if(head == null) return new Node(val);

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = new Node(val);


        return head;
    }


    //----------->>> INSERTING ELEMENT AT A GIVEN POSITION <<<<----------//
    static Node insertPos(Node head, int val, int k){

        if(k==1){
            Node newest = new Node(val);
            newest.next = head;
            head = newest;
            return head;
        }

        int count =0;
        Node temp = head, prev = null;
        while(temp != null){
            count++;
            if(count == k){
                prev.next = new Node(val);
                prev.next.next = temp;
                break;
            }
            prev= temp;
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

        //---->> INSERTING ELEMENT AT FRONT <<-----//

        Node temp1 = null;
        
        head = insertHead(head, 0);   //insert at head
        head = insertTail(head, 8);   //insert at tail
        head = insertPos(head, 9, 1);  //insert element at a given position






        //---->>LL Printing<<------//
        Node mover = head;
        while(mover != null){
            System.out.print(mover.data+" ");
            mover = mover.next;
        }



    }

    
}
