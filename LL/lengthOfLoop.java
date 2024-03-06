class Node{
    int data;
    Node next;

    Node(){}
    Node(int data1){
        this.data = data1;
        this.next = null;

    }
}



public class lengthOfLoop {
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

    static int code1(Node head){                     // optimal code ---self thought using the concept of d and l1 in starting point of a loop
        Node fast = head, slow = head;               // nvm not working for all test cases
        int count = 0;
        while(fast != null && fast.next != null){
            count++;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return count;
            }
        }
        return 0;
    } 
    static int code2(Node head){                   /*first find intersection point and then move one pointer across the loop
                                                        and then  count the no. of steps taken by counter to meet again */ 
        Node fast = head, slow = head;
        
        while(fast != null && fast.next != null){
            
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast = fast.next;
                int count =1;
                while(fast != slow){
                fast = fast.next;
                count++;
                }
                return count;
            }
        }
        

        return 0;
    } 
    
    public static void main(String[] args) {
        Node head = arrtoLL(new int[]{2,3,4,5,6,7,8,9});

        Node ind = null, temp = head;
        int count =0;
        while(temp.next != null){
            count++;
            if(count ==3) ind = temp;

            temp = temp.next;
        }

        temp.next = ind;

        System.out.println(code2(head));
    }
}
