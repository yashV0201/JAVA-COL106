class Node{
    int data;
    Node next;

    Node(){};
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}


public class add2Nums {
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

    static Node add(Node h1, Node h2){
        Node temp1 =h1.next, temp2 = h2.next;
        Node sum = new Node((h1.data+h2.data)%10);
        int carry =(h1.data+h2.data)/10;
        Node temp3 = sum;


        while(temp1 != null && temp2 != null){
            int addn = (temp1.data+temp2.data+carry)%10;
            carry = (temp1.data+temp2.data+carry)/10;
            Node newst = new Node(addn);
            temp3.next =newst;
            temp3 = temp3.next;

            temp1 = temp1.next;
            temp2= temp2.next;

        }

        while(temp1 != null){
            int addn = (temp1.data+carry)%10;
            carry = (temp1.data+carry)/10;
            Node newst = new Node(addn);
            temp3.next =newst;
            temp3 = temp3.next;

            temp1 = temp1.next;
        }

        while(temp2 != null){
            int addn = (temp2.data+carry)%10;
            carry = (temp2.data+carry)/10;
            Node newst = new Node(addn);
            temp3.next =newst;
            temp3 = temp3.next;

            temp2 = temp2.next;
        }

        if(carry != 0){
            Node newst = new Node(carry);
            temp3.next =newst;
            temp3 = temp3.next;

        }

        return sum;

    }

    static Node Add(Node h1, Node h2){
        Node t1 = h1, t2 = h2;
        Node dummy = new Node(-1);           // needed a new list so we created a dummy node
        Node curr = dummy;                 // updating list using a "current" node
        int carry =0;
        while(t1 != null || t2 != null){
            int sum = carry;
            if(t1 != null) sum += t1.data;
            if(t2 != null) sum += t2.data;

            Node temp = new Node(sum%10);
            curr.next = temp;
            curr = curr.next;

            carry = sum/10;

            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }

        if(carry != 0){
            Node temp = new Node(carry);
            curr.next = temp;
            curr = curr.next;
        }


        return dummy.next;
    }




    public static void main(String[] args) {
        Node head1 = arrtoLL(new int[]{9,9,1});
        Node head2 = arrtoLL(new int[]{9,9});

        Node head = Add(head1, head2);

        print(head);
        
    }
}
