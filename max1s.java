import java.util.Arrays;

public class max1s {
    static int max(int[] a){
        int n = a.length;
        int i = 0;
        int sum = Integer.MIN_VALUE;

        while(i<n){
            if(a[i]==1){
                int count =0;
                while(i<n && a[i] ==1 ){
                    count++;
                    i++;

                }
                if(sum<count){
                    sum = count;
                }
            }

            else{
                i++;
            }

        }

        return sum;


    }

    static int maxOnes(int[] a){
        int n = a.length;
        int sum = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(a[i]==1){
                count++;
            }

            else{
                count = 0;
            }

            sum = Math.max(count, sum);
        }

        return sum;
    }



    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,1,0,0,0,1,1,1,0};
        int s= maxOnes(a);
        System.out.println(s);
    }
    
}
