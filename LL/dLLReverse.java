class Node{
    int data;
    Node next;
    Node previous;

    Node(){

    }

    Node(int data1){
        this.data = data1;
        this.next =null;
        this.previous = null;
    }
}




public class dLLReverse {
    static Node arrToDLL(int[]a){
        Node head  = new Node(a[0]);
        Node prev = head;
        for(int i=1;i<a.length; i++){
            Node temp = new Node(a[i]);
            prev.next = temp;
            temp.previous = prev;
            prev = temp;
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

    static Node reverse(Node head){
        Node temp = head;
        Node prev = null;

        while(temp != null){
            prev = temp.previous;
            temp.previous = temp.next;
            temp.next = prev;

            prev = temp;
            temp = temp.previous;
            
        }

        return prev;                                // return tail of original linked list....tail of original linked list becomes head of reversed LL
        
        
    }

    public static void main(String[] args) {
        Node head = arrToDLL(new int[]{5,3,4,9,7,2,1});

        head = reverse(head);

        print(head);
    }
    
}
