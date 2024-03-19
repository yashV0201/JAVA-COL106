import java.util.Arrays;

public class basics {
    static void reverseArr(int[] arr, int left, int right){
        if(left>=right) return;

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverseArr(arr,left+1,right-1);
    }

    static boolean checkPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left<right){
            char l = s.charAt(left) , r = s.charAt(right);
            if(!Character.isLetterOrDigit(l)){
                left++;
            }
            else if(!Character.isLetterOrDigit(r)){
                right--;
            }

            else if(Character.toLowerCase(l) != Character.toLowerCase(r)){
                return false;
            }
            else{
                left++;
                right--;
            }
        }

        return true;
    }

    static int aToi(String s){
        s = s.trim();
        int i  = 0;
        long sum = 0;
        boolean neg =false;
        if(s.charAt(i) == '-'){
            neg = true;
            i++;
        }
        else if(s.charAt(i) == '+'){
            neg = false;
            i++;
        }

        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit  = s.charAt(i) - '0';
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            sum = (sum*10) + digit;
            i++;
        }

        if(neg) sum *=-1;

        
        
        return (int)sum;
    }

    static int reverseInt(int num){
        int sum = 0;
        boolean neg = false;
        if(num<0){
            num = -num;
            neg = true;
        }

        while(num != 0){
            int digit = num%10;
            if(sum>Integer.MAX_VALUE/10 ||(sum == Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10))
            return neg? Integer.MIN_VALUE:Integer.MAX_VALUE;
            sum = sum*10 + digit;
            num = num/10;
        }


        return neg? -sum : sum;
    }

    static String reverseWords(String s){
        s = s.trim();
        int start = s.length()-1, end = s.length()-1;
        StringBuilder b = new StringBuilder();
        while(start>=0){
            if(s.charAt(start)==' '){
                start--;
                end = start;
                continue;
            }
            while(start-1>=0 && s.charAt(start-1) != ' '){
                start--;
            }
            for(int i = start; i<= end; i++){
                b.append(s.charAt(i));

            }
            if(start != 0 )b.append(" ");
            
            start = start-2;
            end = start;
        }

        return b.toString();
    }
    static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstString = strs[0];
        String lastString = strs[strs.length - 1];
        int index = 0;
        for (int i = 0; i < Math.min(firstString.length(), lastString.length()); i++) {
             if (firstString.charAt(i) == lastString.charAt(i)) {
                 index++;
             }
             else {
                 break;
             }
        }
        return firstString.substring(0, index);
    }



    public static void main(String[] args) {
        /* int[] arr = {1,4,6,7,8,3,2};
        String s = "A man, a plan, a canal: Panama";

        reverseArr(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
        System.out.println(checkPalindrome(s)); */
        /* String s = "  9223372036854775808";
        System.out.println(aToi(s));
        int x = -2147483648;
        System.out.println(Integer.MAX_VALUE); */
        String s = "a good   example";
        System.out.println(reverseWords(s));

        
    }
    
}
