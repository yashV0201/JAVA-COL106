import java.util.Arrays;

public class matrixRotate90 {
    static int[][] brute(int[][]a){                  // simple approach TC:O(n*n) SC:O(n*n)
        int[][]b = new int[a.length][a[0].length];
        for(int i =0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                b[j][a.length -1-i] = a[i][j];
            }
        }

        return b;
    }

    static int[][] optimal1(int[][]a){   
        int n = a.length;
        for(int i=0; i<n/2 ; i++){

            int j = i;
            while(j<n-i-1){
                int top = j ;    //a[..][top]  increase
                int right = j;  // a[right][..]  increase
                int bottom = n-1-j;  // a[..][bottom] decrease
                int left = n-1-j;   // a[left][..] decrease
                int temp = a[i][top];
                a[i][top] = a[left][i];
                a[left][i] = a[n-1-i][bottom];
                a[n-1-i][bottom] = a[right][n-1-i];
                a[right][n-1-i] = temp;
                j++;
            }


        }
        return a;
    }

    public static void main(String[] args) {
        int[][] a =optimal1(new int[][]{
            {11,12,13,14},
            {15,16,17,18},
            {19,20,21,22},
            {23,24,25,26}

        });

        for(int[] ele: a){
            System.out.println(Arrays.toString(ele));
        }

    }
    
}
