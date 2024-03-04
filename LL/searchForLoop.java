import java.util.HashMap;
import java.util.Map;

class Node{
    int data;
    Node next;

    Node(){}

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}





public class searchForLoop {
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

    static boolean brute(Node head){

        Map<Node,Integer> hm = new HashMap<>();

        Node temp = head;

        while(temp != null){
            if(hm.containsKey(temp)) return true;
            
            hm.put(temp,hm.getOrDefault(temp, 0)+1);
            
            temp = temp.next;
        }

        return false;

    }

    //=======------->>> optimal method for  <<<<====---------------- 

    static boolean optimal(Node head){                     // tortoise hare algorithm
        Node fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Node head = arrtoLL(new int[]{2,3,4,5,6});

        Node ind = null, temp = head;
        int count =0;
        while(temp.next != null){
            count++;
            if(count ==3) ind = temp;

            temp = temp.next;
        }

        temp.next = ind;

        Node head2 = arrtoLL(new int[]{2,4,7,3,8,});


        System.out.println(optimal(head));
        //print(head);
    }
}    

