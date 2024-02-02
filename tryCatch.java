public class tryCatch {
    public static void main(String[] args) {
        int a =2;
        int b =0;
        int c;

        try{
            c=(a/b);
            System.out.println(c);
        }
        catch(ArithmeticException e){
            System.out.println("Divide by zero not possible.");
        }
    }
    
}
