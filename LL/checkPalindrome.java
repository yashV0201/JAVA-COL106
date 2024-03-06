class Node{
    int data;
    Node next;

    Node(){}
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}



public class checkPalindrome {
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

    static boolean optimal(Node head){                             // done in plases
        Node fast = head, slow = head;                            // first of all finding the middle element
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        } 

        Node temp = slow.next, prev = null;                      // next is reversing the second half of the list>>> i.e. starting from the next of the middle element
        while(temp != null){
            Node next = temp.next;
            temp.next = prev;
            prev =temp;
            temp = next;
        }

        slow.next = prev;                                       // connecting the head of the new list as the next of middle element
        
        Node first = head, second = prev;
        while(second != null){
            if(first.data != second.data) return false;
            first =first.next;
            second= second.next;
        }

        temp = slow.next; prev = null;                      // next is reversing the second half of the list back to it's original form
        while(temp != null){
            Node next = temp.next;
            temp.next = prev;
            prev =temp;
            temp = next;
        }
        slow.next = prev;  


        return true;                                         // Suggesttion: try to make different function for reversing and finding the middle element to keep the code neater
    }

    public static void main(String[] args) {
        Node head = arrtoLL(new int[]{1,2,3,4,5,6,5,4,3,2,1});
        System.out.println(optimal(head));
        print(head);
    }
    
}
