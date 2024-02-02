

public class Main {
    public void printinfo(){                      //static not written..so we have to make object of Main class and then call the funtion on that object for the function to run.
        System.out.println("hello world!");
    }

    public static void main(String arg[]){
    Main obj = new Main();                     //making object of Main class
    obj.printinfo();                           // calling our printinfo function on Main class object.
    }
    
}


