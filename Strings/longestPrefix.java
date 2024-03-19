import java.util.Arrays;

public class longestPrefix {

    // return the longest prefix common in a given array of Strings..e.g. ["flower","flow","fleet"] => "fl", ["dog","cat"]=>"";

    static String mySol(String[] strs){

        /* what did i do?
        first of all scanned for smallest string, because this is the max length of prefix possible, assigned it as pre(final ans)
        then gone through each element and compared the characters with pre... created a string builder and added these characters to it as ans.
        then assigned pre as ans;
        returned pre. */

        String min = "";
        int minLength = Integer.MAX_VALUE;
        for(String s: strs){
            if(s.length()<minLength){
                min = s;
                minLength = min.length();
            }
        }

        String pre = min;

        for(int i =0; i<strs.length; i++){
            if(strs[i] == min) continue;

            StringBuilder ans = new StringBuilder();
            int n = Math.min(strs[i].length(),pre.length());
            for(int j = 0; j<n; j++){
                if(strs[i].charAt(j)== pre.charAt(j)){
                    ans.append(pre.charAt(j));
                }
                else{
                    break;
                }
                    
                
            }

            pre = ans.toString();
        }


        return pre;
    }

    static String optimal(String[] strs){
        /* principles used are sorting of a string and uses of substring
         * a string is sorted in dictionary order, so,
         * in these cases the strings are sorted according to the characters after the longest common prefix
         * also we know that the longest prefix cannot exceed smallest element
         * so we compare the smallest element of the array with the largest element.
         * Case 1(common prefix exists): if more than 2 elements then the middle elements must also have the common prefix,(beacuse of dictionary order)
         * Case 2(does not exist): then acc tp dictionary order the odd string will lie at one of the ends.
         * Thus, if we compare two end cases, we can know the common prefix
         * so compare the first element's characters tp last element's correspomding characters
         * Use an index pointer:
         *  if characters are same, then increase the pointer
         *  else break from the loop
         * 
         * at the end return substring of the first element containing characters from index 0 to index;
         */
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        int index = 0;
        for(int i = 0; i<Math.min(first.length(), last.length());i++){
            if(first.charAt(i)==last.charAt(i)){
                index++;
            }
            else break;
        }

        return first.substring(0,index);

    }

    public static void main(String[] args) {
        String[] arr = {"a","ab","abc"};

        System.out.println(mySol(arr));
        System.out.println(optimal(arr));
    }
    
}
