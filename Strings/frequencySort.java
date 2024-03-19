import java.util.HashMap;

public class frequencySort {

    static String mySol(String s){
        /* stored the frequency of letters in a hashmap
        found maximum frequency from the map by iterating theough the keys
        appended the letter frequency number of times in a stringbuilder object
        deleted the key value pair from the hashmap
        reperated the steps 2-4 till hashmap becomes empty */
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),1);
            }
            else{
                hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!hm.isEmpty()){
            int max = Integer.MIN_VALUE;
            char maxc = 'a';
            for(Character key : hm.keySet()){
                if(hm.get(key)>max){
                    max = hm.get(key);
                    maxc = key;
                }
            }
            for(int i = 0; i<max; i++){
                ans.append(maxc);
            }

            hm.remove(maxc);

        }

        return ans.toString();
    }
    
    static String alsoMySolButOptimal(String s){
        /* similar approach as previous one
        except no hashmap made, stored the frequency using hashing in a new array
        also no new string builder made, changed the existing array.

        found the character correspponding to maximum freq and replaced it
        according to its frequency in the roiginal array, and also reduced it's frequency to zer
        again repeated the last two steps until reached the end of array */

        
        char[] arr = s.toCharArray();
        int[] freq = new int[128];
        for(int i=0; i<arr.length; i++){
            freq[arr[i]]++;
        }
        int i = 0;
        while(i<arr.length){
            char max = ',';
            for(int j=0; j<128;j++){
                if(freq[j]>freq[max]) max = (char)j;
            }
            while(freq[max] != 0){
                arr[i] = max;
                i++;
                freq[max]--;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "trrreeeesasssssss";
        System.out.println(mySol(s));
        System.out.println(alsoMySolButOptimal(s));
    }
}
