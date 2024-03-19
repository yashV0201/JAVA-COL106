public class longestOddNum {
    // return the longest odd number in a string, e.g. "52" => 5, "420" =>"", "3570"=> 357
    /* we notice that
     * the number ending with an odd digit is always an odd number
     * so the largest odd number would be largest substring ending with an odd digit
     * So start iteration from back and find the first odd number and return the subsrting(0, index) 
     */

    static String largest(String num){
        
        for(int i=num.length()-1;i>=0;i--){
            int digit = num.charAt(i)-'0';
            if(digit%2==1){
                return num.substring(0,i+1);
            }
        }

        return new String("");
    }
    
    public static void main(String[] args) {
        String num="240";
        System.out.println(largest(num));
    }
    
}
