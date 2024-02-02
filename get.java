class Branch{
    public void getBranch(){
        System.out.println("I am in IIT.");
    }
}

class CompSc extends Branch{
    public void getBranch(){
        System.out.println("I am in CS.");
    }
}

class Electrical extends Branch{
    public void getBranch(){
        System.out.println("I am in Electrical.");
    }
}

public class get{
    public static void main(String args[]){
        Branch s1 = new Branch();
        Branch s2 = new CompSc();
        Branch s3 = new Electrical();

        s1.getBranch();
        s2.getBranch();
        s3.getBranch();
        
    }

} 