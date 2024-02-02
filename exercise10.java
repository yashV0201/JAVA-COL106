import java.util.Scanner;

public class exercise10 {

    public static void isSame(int num1, int num2){
        if(num1>0 & num2>0){
            if(num1%10==num2%10){
                System.out.println(true);
            }
            else{
                System.out.println(false);
            }
        }
        else{
            System.out.println(-1);
        }
    }


    public static void main(String args[]){
        int a,b;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter first number: ");
            a= sc.nextInt();
            System.out.println("Enter Second Number: ");
            b = sc.nextInt();
        }
        System.out.println("Same last digit: ");
        isSame(a,b);
    }
    
}
