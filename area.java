class figure{
    public void getArea(int a, int b){
        int area = a*b;
        System.out.println(area);
    }

    public void getArea(int a){
        int area = a*a;
        System.out.println(area);
    }
}





public class area {
    public static void main(String[] args) {
        figure square = new figure();
        figure rectangle = new figure();
        square.getArea(2);
        rectangle.getArea(2, 3);
    }
    
}
