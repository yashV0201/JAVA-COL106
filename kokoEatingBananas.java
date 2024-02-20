import java.util.Scanner;
public class kokoEatingBananas {

    static int optimal(int[]a, int h){
        int min = Integer.MAX_VALUE, max= Integer.MIN_VALUE;
        int n = a.length;
        for(int i =0; i<n; i++){
            if(a[i]>=max){
                max = a[i];
            }

            if(a[i]<=min){
                min = a[i];
            }
        }

        long low= 0, high = max; 
        int ans = -1;
        while(low<=high){
            long mid=(low+high)/2;
            long k = mid;
            long t=0;
            for(int i =0; i<n; i++){
                if(a[i]%k !=0){
                    t += (a[i]/k)+1;
                }
                else{
                    t += a[i]/k;
                }
            }

            if(t>h){
                low = mid+1;
            }
            else if(t<=h){
                ans = (int)(mid);
                high = mid-1;
            }
            //else{
                //return mid;
           // }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();

        int a = optimal(new int[]{30,11,23,4,20},h);
        System.out.println(a);
    }
    
}
