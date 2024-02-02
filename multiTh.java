public class multiTh implements Runnable {
    int n =5; 
    private int count =0;

    public void getCount(){System.out.println("Done");}
    public synchronized void incrSync(){
        
        count++;}

    public void run(){
        for(int i =0; i<n;i++){
            incrSync();
            System.out.println("count is :" + count+" "+Thread . currentThread (). getName ());
        }
    }


    public static void main(String[] args) {
        multiTh tmp = new multiTh();
        Thread t1 = new Thread(tmp);
        Thread t2 = new Thread(tmp);
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException ie){
            System.out.println(ie);
            ie.printStackTrace();

        }
        tmp.getCount();
    }

    
}
