import java.util.ArrayList;

public class returnList {
    /* demonstration on hwo we can pass a list without passing it in as an argument in a function */

    static ArrayList<Integer> findKey(int[] arr, int key, int index){
        ArrayList<Integer> list  = new ArrayList<>();
        if(index == arr.length) return list;

        if(arr[index] == key){
            list.add(index);
        }

        ArrayList<Integer> ans = findKey(arr, key, index+1);     // contains answers from below calls
        list.addAll(ans);                                        // accumulating all the answers: answers from this call + ans from below calls

        return list;                                             // returning the final list(containing current + previous answers(if there are any))
    }

    static ArrayList<Integer> findKey2(int[]a, int key, int index, ArrayList<Integer> list){
        if(index == a.length) return list;

        if(a[index] == key) list.add(index);

        return findKey2(a, key, index+1, list);
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,4,5};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = findKey(a, 4, 0);
        

        System.out.println(list2.toString());
    }
    
}
