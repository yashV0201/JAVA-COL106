class Node{
    int data;
    Node next;

    Node(){

    }

    Node(Node next1, int data1){
        this.next = next1;
        this.data = data1;
    }

    Node(int data1){
        this.data = data1;
        this.next=  null;
    }
}

public class LLbasics{
    public static void main(String[] args) {

        int[] arr = {2,3,4,5,6,7};

        Node head = new Node(arr[0]);  //assigning first element of array as head of the LL
        Node mover = head;              // creating a temporary mover array

        for(int i =1; i<arr.length;i++){          

            if(mover.next ==null){
                mover.next = new Node(arr[i]);
            }
            mover = mover.next;
        
        }


        Node newest = new Node(1);    //inserting an element at the beginning of LL
        newest.next= head;
        head = newest;


                                      //deleting the tail of a LL
        Node temp = head;
        while(temp.next.next != null){

            temp = temp.next;
        }

        temp.next = null;




        Node mov = head;
        while(mov != null){
            System.out.print(mov.data+" ");
            mov = mov.next;
        }

        

        

        
        System.out.println();


        System.out.println("heelo "+mover.data);

    }
}