import java.util.Scanner;

public class exercise11 {

    public static int GCD(int a, int b){      //used Euclid's Algorithm; for calc. GCD(A,B)
                                                //Rules: GCD(A,0)==A, GCD(0,B)==B and GCD(A,B)==GCD(B,R)  where A= B*Q + R...
                                                //hence R is remainder when A is divided by B or... R== A%B

        int gcd=1;    
        if(a==0 || b ==0){

            if(a==0){
                gcd=b;
                return gcd;
            }
            if(b==0){
                gcd=a;
                return gcd;
            }
        }

        else{
            if(a>b){
                return GCD(b, a%b);
            }
            else{
                return GCD(a, b%a);
            }
        }
        
        return gcd;

    }

    public static int LCM(int a, int b){        // used LCM(A,B)*HCF(A,B)==A*B;
        return (a*b)/GCD(a, b);
    }


    public static void main(String args[]){
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter A: ");
            int a = sc.nextInt();
            System.out.println("Enter B: ");
            int b = sc.nextInt();


            System.out.println("GCD of A & B is: " +GCD(a,b));
            System.out.println("LCM of A & B is: " +LCM(a,b));
        }
    
    }


    
}


