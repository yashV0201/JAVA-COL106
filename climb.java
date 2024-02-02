import java.math.BigInteger;

public class climb {

    static BigInteger fact(int n){

        BigInteger factorial = BigInteger.ONE;
        for(int i = 1; i <= n; ++i)
        {
            // factorial = factorial * i;
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;

    }
    
    public int climbStairs(int n) {

        if(n==1) return 1;
        else{
        int x=0;
        int y =0;
        int sum =0;

        while(x>=0){
            x = n - (2*y);

            //sum += fact(x+y).divide(fact(x).multiply(fact(y)));

            y++;

        }
       return sum; }
    }

    public static void main(String[] args) {
        climb b = new climb();

        double a=2;
        double z =3;

       // double div = a/b;

        
        System.out.println(b.climbStairs(14));
        System.out.println(fact(23));
    }
    
}
