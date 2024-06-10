public class sumOfSubArrayMins {
    static int optimal(int[] arr){
        int n = arr.length;
        int sum =0;
        for(int k =0;k<n;k++){
            int i = 0;
            
            while(i<n-k){
                int min = Integer.MAX_VALUE;
                int j=i+k;
                for(int a = i; a<=j;a++){
                    min = Math.min(arr[a], min);
                }
                i++;
                sum+=min;
            }
            
            
        }
        return sum%(1000000000+7);
    }

    public static void main(String[] args) {
        int[] arr ={11,81,94,43,3};
        System.out.println(optimal(arr));
    }
}
