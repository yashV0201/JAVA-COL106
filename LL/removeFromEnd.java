class Node{
    int data;
    Node next;

    Node(){}

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}




public class removeFromEnd {
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

    static Node code1(Node head, int k){    ///main code: reverse the list...remove ltk element as ususal...again reverse it
        Node temp = head, prev= null;
        while(temp != null){                        // bekar method...boht saari conditions lagani pad rahi hain
            Node next = temp.next;
            temp.next =prev;
            prev =temp;
            temp =next;
        }

        if(k==1){
            prev = prev.next;
        }

        else{
            Node curr = prev, back = null;
            int count =0;
            while(curr != null){
                count++;
                if(count == k){
                    if(curr.next==null){
                        back.next = curr.next;
                        curr.next = null;
                        head = back;
                        break;
                    }
                    else{
                        back.next = curr.next;
                        curr.next = null;
                        break;
                    }
                }
                back = curr;
                curr = curr.next;
            }
        }




        temp = prev; prev= null;
        while(temp != null){
            Node next = temp.next;
            temp.next =prev;
            prev =temp;
            temp =next;
        }

        
            

        return head;
    }

    static Node code2(Node head, int k){
        Node fast = head, slow =head, back = null;
        int count = 0;
        while(fast != null){
            count++;
            if(count > k){
                fast = fast.next;
                back = slow;
                slow = slow.next;

            }

            else fast = fast.next;
        }

        if(slow == head) return head.next;

        back.next = slow.next;
        slow.next = null;


        return head;
    }







    public static void main(String[] args) {
        Node head = arrtoLL(new int[]{1,3,5,6,7,8,9});

        head = code2(head, 1);

        print(head);
    }
}
