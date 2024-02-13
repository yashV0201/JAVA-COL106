public class spiralMatrix {
    public static void self(int[][]a){
        int n = a.length;
        int m = a[0].length;

        for(int i=0; i<=n/2; i++){
            int j =i;
            boolean test1 = false;
            boolean test2 = false;

            //for moving right
            while(j<m-i){
                System.out.print(a[i][j]+" ");
                j++;
                test1= true;

            }
            j =i+1;

            //for moving down
            while(j<n-i){
                System.out.print(a[j][m-1-i]+" ");
                j++;
                test2 = true;

            }
            j =i+1;

            //for moving left
            while(j<m-i && (test1&test2)){
                System.out.print(a[n-1-i][m-1-j]+" ");
                j++;

            }
            j =i+1;

            //for moving up
            while(j<n-i-1 &&(test1&test2)){
                System.out.print(a[n-j-1][i]+" ");
                j++;

            }





        }
    }
    public static void main(String[] args) {
        int[][] a = {
            {1,2,3,4,5},
            {16,17,18,19,6},
            {15,24,25,20,7},
            {14,23,22,21,8},
            {13,12,11,10,9}
        };
        int[][] b = {
            {1,2,3,4,5,6},
            {18,19,20,21,22,7},
            {17,28,29,30,23,8},
            {16,27,26,25,24,9},
            {15,14,13,12,11,10}
        };
        int[][] c = {
            {1,2,3},
            {10,11,4},
            {9,12,5},
            {8,7,6}
        };

        

        self(b);
    }
    
}
