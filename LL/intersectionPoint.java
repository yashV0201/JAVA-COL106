class Node{
    int data;
    Node next;
    
    Node(){}
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}


public class intersectionPoint {
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

    static int findLength(Node head){
        Node temp = head;
        int count =0;
        while(temp != null){
            count++;
            temp = temp.next; 
        }

        return count;
    }

    static Node intersection(Node head1, Node head2, int diff ){
        Node t1 = head1, t2 = head2;
        while(diff != 0){
            diff--;
            t1 = t1.next;
        }
        while( t2 != null){
            t1 = t1.next;
            t2 = t2.next;
            if(t1 == t2) return t1;
        }

        return null;

    }

    static Node optimal(Node h1, Node h2){
        Node t1 = h2, t2 = h2;
        int l1 = findLength(h1), l2 = findLength(h2);
        int diff = Math.abs(l1-l2);
        if(l1>l2) return intersection(h1,h2,diff);
        else return intersection(h2,h1,diff);

    }

    static Node optimal2(Node h1, Node h2){
        Node t1=h1, t2=h2;
        while(t1 != t2){
            t1 = t1 == null? h2:t1.next;
            t2 = t2 == null? h1: t2.next;  
        }
        
        return t1;
    }

    
        
    public static void main(String[] args) {
        Node head1 = arrtoLL(new int[]{2,4,5,6,7,8});
        Node head2 = arrtoLL(new int[]{
            1,4,3,5,6,7,8
        });
        Node temp = head2, five= head1;
        while(temp != null && temp.data != 5 ){
            temp = temp.next;
        }
        while(five != null && five.data !=5 ){
            five = five.next;
        }

        if(five != null || temp != null)temp.next = five;

        Node inter = optimal2(head1, head2);
        System.out.println(inter.data);


    }
}
