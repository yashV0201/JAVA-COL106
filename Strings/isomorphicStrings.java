import java.util.HashMap;

public class isomorphicStrings {
    /* 
     * Given two strings s and t, determine if they are isomorphic.
        Two strings s and t are isomorphic if the characters in s can be replaced to get t.
        No two characters are mapped to the same character...but a character can be mapped to itself.
        example: s="egg",t="add" => true    e->a, g->d
                s="foo", t="bar" => false   f->b, o->a, o->r(not possible)
                s="badc", t="baba" => false   b->b, a->a, d->b(not possible)

                only one-to-one mapping possible
     */

    static boolean mySol(String s, String t){
        //map the s and t's charactes in a hashmap and then compare
        // we will use a reverse hashmap for cross-verification
        if(s.length() != t.length()) return false;

        HashMap<Character,Character> hm = new HashMap<>();
        HashMap<Character,Character> hmRev = new HashMap<>();
        
        for(int i =0; i<s.length(); i++){
           char st = s.charAt(i);
           char ts = t.charAt(i);

           if(hm.containsKey(st)){
            if(hm.get(st) != ts) return false;
            else continue;
           }

           else{
            if(hmRev.containsKey(ts)){
                return false;
            }

            hm.put(st,ts);
            hmRev.put(ts,st);

           }
        }

        return true;
    }

    static boolean optimal(String s, String t){
        if(s.length() != t.length()) return false;
        int[] map1 = new int[128];
        int[] map2 = new int[128];

        for(int i = 0; i<s.length(); i++){
            if(map1[s.charAt(i)] != map2[t.charAt(i)]){
                return false;
            }

            map1[s.charAt(i)] = i+1;
            map2[t.charAt(i)] = i+1;
        }

        return true;
    }

    public static void main(String[] args) {
        String s= "egg", t = "aba";
        System.out.println(optimal(s, t));
    }
}
