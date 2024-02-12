import java.util.ArrayList;
import java.util.Arrays;

public class setMatrixZero {

    //------==>>HELPER FUNCTIONS<<==----------//

    static void zero(int[][]a, ArrayList<Integer>k){   //helper for bruteSelf

        for(int n =0; n< k.size();n++){
            for(int i= 0; i<a.length; i++){
                for(int j =0; j<a[i].length; j++){
                    if(i==k.get(n)){
                        a[i][j] =0;
                    }
    
                    else if(j==k.get(n)){
                        a[i][j] =0;
                    }
    
                }
            }

        }
        
    }


    static void markrows(int[][]a, int i){
        for(int j =0; j<a[i].length; j++){
            if(a[i][j] !=0){
                a[i][j]=-1;

            }
             
        }
    }

    static void markcolumns(int[][]a, int j){
        for(int i =0; i<a.length; i++){
            if(a[i][j] !=0){
                a[i][j]=-1;

            }
        }
    }





     //-------->>MAIN FUNCTIONS<<----------------//

    public static int[][] brute(int[][]a){

        for(int i =0; i<a.length; i++){
            for(int j =0; j<a[i].length; j++){
                if(a[i][j]==0){
                    markrows(a,i);
                    markcolumns(a,j);
                }
            }
        }

        for(int i =0; i<a.length; i++){
            for(int j =0; j<a[i].length; j++){
                if(a[i][j]==-1){
                    a[i][j]=0;
                }
            }
        }

        return a;
    }


    static int[][] bruteSelf(int[][]a){

        ArrayList<Integer> li = new ArrayList<>();


        for(int i=0; i<a.length; i++){
            for(int j = 0; j<a[i].length; j++){
                if(a[i][j]==0){
                    li.add(j);
                    
                    
                }

            }

        }
        zero(a, li);
        return a;
    }

    static int[][] better(int[][]a){
        int[] rows = new int[a.length];
        int[] columns = new int[a[0].length];

        for(int i =0; i<a.length; i++){
            for(int j =0; j<a[i].length; j++){
                if(a[i][j]==0){
                    rows[i] = 1;
                    columns[j]=1;
                }
            }
        }

        for(int i =0; i<a.length; i++){
            for(int j =0; j<a[i].length; j++){

                if(rows[i] ==1 || columns[j]==1){
                    a[i][j]=0;
                }
            }
        }


        return a;

    }

    static int[][] optimal(int[][]a){
        // for rows => a[..][0]  information about rows will be stored in 0th column
        //for colms => a[0][..]  information about columns will be stored in 0th row
        int col0 = 1;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length;j++){
                if(a[i][j]==0){
                    // for rows
                    a[i][0] =0;
                    // for columns
                    if(j != 0) a[0][j] = 0;
                    else col0 = 0;

                }
            }
        }

        for(int i =1; i<a.length; i++){
            for(int j=1; j<a[0].length; j++){
                if(a[i][0]==0 || a[0][j]==0){
                    a[i][j] =0;
                }
            }
        }

        if(a[0][0]==0){
            for(int j =0; j<a[0].length; j++){
                a[0][j] =0;
            }
        }

        if(col0==0){
            for(int i =0; i<a.length; i++){
                a[i][0] =0;
            }
        }
        
        return a;
    }

    public static void main(String[] args) {
        int[][] a = optimal(new int[][]{{1,1,1,1},{1,0,1,0},{1,1,1,1}});
        int[][] b = {{0,1,2,0},{1,1,1,1},{1,1,1,1}};

        for(int[] ele: a){
            System.out.println(Arrays.toString(ele));
        }
    }
    
}
