public class multithreads extends Thread{
    
    public void run (){
         for ( int i =1; i <10; i ++){
             System . out . println ( Thread . currentThread (). getName ()+
            " says hello "+ i+" times ");
            //try { Thread . sleep (1000);} catch ( InterruptedException e ){}
         }
    }



    public static void main ( String args []) {
         multithreads thr1 = new multithreads();
         multithreads thr2 = new multithreads();
         thr1 . start ();
         thr2 . start ();
        }
         
    
}
