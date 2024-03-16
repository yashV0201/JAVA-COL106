import java.util.ArrayList;


public class heaps {
    private ArrayList<Integer> list;

    public heaps(){
        list = new ArrayList<>();
    }

    private void swap(int first, int second){
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int left(int index){
        return 2*index +1;
    }

    private int right(int index){
        return 2*index +2;
    }

    private void upheap(int index){
        if(index == 0) return;
        int p = parent(index);
        if(list.get(index)<list.get(p)){
            swap(index, p);
            upheap(p);
        }
    }

    public void insert(int value){
        list.add(value);
        upheap(list.size()-1);
    }

    private void downheap(int index){
        int min = index;
        int left = left(index);
        int right =  right(index);
        if(left<list.size() && list.get(min)>list.get(left)){
            min = left;
        }
        if(right<list.size() && list.get(min)>list.get(right)){
            min = right;
        }

        if(min != index){
            swap(min, index);
            downheap(min);
        }
    }

    public int remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty heap!");
        }
        int temp = list.get(0);
        int last  = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            downheap(0);
        }

        return temp;
    }

    public static void main(String[] args) throws Exception {
        heaps h  = new heaps();
        h.insert(12);
        h.insert(5);
        h.insert(19);
        h.insert(77);
        h.insert(56);
        h.insert(14);
        h.insert(23);


        System.out.println(h.remove());
    }
}
