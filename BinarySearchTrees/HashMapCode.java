import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {

    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){ // between 0 to N-1
            int bi = key.hashCode();
            return Math.abs(bi)%N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            
            for(int i =0; i<ll.size();i++){
                if(ll.get(i).key==key) return i;
            }

            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[2*N];

            for(int i=0; i<N*2; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i= 0; i<oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j = 0; j<ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //di = -1

            if(di == -1){
                buckets[bi].add(new Node(key, value));
                n++;
            }
            else{
                Node data = buckets[bi].get(di);
                data.value = value;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0){
                // rehashing
                rehash();
            }




        }
        
    }

    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("india",47);
        
    }
    
}
