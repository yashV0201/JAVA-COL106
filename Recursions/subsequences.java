import java.util.ArrayList;


public class subsequences {
    static void print(int[] arr,int index, ArrayList<Integer> list ){
        if(index>=arr.length){
            System.out.print(list.toString()+", ");
            return;
        }

        list.add(arr[index]);
        print(arr, index+1, list);
        list.remove(list.size()-1);
        print(arr,index+1, list);
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2};
        ArrayList<Integer> list = new ArrayList<>();
        print(arr,0,list);

    }
}
