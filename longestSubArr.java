public class longestSubArr {

    static int subArr(int[] a, int k){

        int c_max = -1;
        for(int i=0; i<a.length;i++){
            int left=i;
            int sum=0;
            int count= 0;
            while(left<a.length && sum<k){
                count++;
                sum = sum +a[left];
                left++;


            }
            if(sum == k){c_max = Math.max(c_max, count);}
            else continue;
            
        }

        return c_max;
    }

    public static void main(String[] args) {
        int a = subArr(new int[]{2,3,5,1,1,1,1,-1,2,2,2,9}, 9);
        System.out.println(a);
    }
    
}
