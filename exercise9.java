import java.util.Scanner;



public class exercise9 {

    public static void my(int year){
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    System.out.println(true);
                }
                else{
                    System.out.println(false);
                }
            }
            else{
                System.out.println(true);
            }
        }
        else{
            System.out.println(false);
        }
            
    
    }

    
        
        
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter year: ");
            int year= sc.nextInt();

            System.out.println("The given year is leap: ");
            my(year);
        }

       

        

    }

}   
    

