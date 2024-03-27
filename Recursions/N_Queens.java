
import java.util.ArrayList;
import java.util.HashSet;

public class N_Queens {

    static boolean helper(ArrayList<int[]> list, int i, int j){
        /* this function is used to check if it is possible to place a queen at a particular position
         * this is done by checking if it is not lying in the path of previous queens
         * path of previous queens is defined by(let i and j be indices) x=i, y=j(for row and col) and x-i = j-y(for diagonals)
         * so this gives true if queen lies in the path of previous queens and we do not place the queen there
         */
        if(list.size() == 0) return true;
        boolean ans = false;
        for(int[] arr: list){
            ans  = ans || (i==arr[0] || j == arr[1] || Math.abs(i-arr[0])==Math.abs(j-arr[1]));
            
        }

        return ans;
    }

    static void posns(int N, int n,int x, int y, ArrayList<int[]> list,HashSet<ArrayList<ArrayList<String>>> fin){
        /* approach taken is place queens one by one and store their attack path information 
         * before placing the next queen check if it is possible to place using the helper function
         * 
        */
        if(x==N && y==N){
            if(n==0){
                ArrayList<ArrayList<String>> ans = new ArrayList<>();
                for(int i=0;i<N;i++){
                    for(int j = 0; j<N; j++){
                        if(list.get(j)[0]==i){
                            ArrayList<String> row = new ArrayList<>();
                            for(int k = 0;k<N;k++){
                                if(list.get(j)[1]==k) row.add("Q");
                                else row.add("."); 
                            }
                            ans.add(row);
                        }
                    }
                }
                
                // for(ArrayList ele : ans){
                //     for(int i=0; i<N;i++){
                //         System.out.print(ele.get(i)+" ");
                //     }
                //     System.out.println();
                // }
                // System.out.println();
                fin.add(ans);

            }

            return;
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(x>0 && y>0){
                    if((i==x || j==y || Math.abs(i-x) == Math.abs(j-y)) || helper(list, i, j)) continue;
                }
                int[] arr = {i,j};
                list.add(arr);
                posns(N, n-1, x+1, y+1, list,fin);
                list.remove(list.size()-1);

            }    
                
        }
    }



    public static void main(String[] args) {
        int N =5;
        ArrayList<int[]> list = new ArrayList<>();
        HashSet<ArrayList<ArrayList<String>>> fin = new HashSet<>();

        // list.add(new int[]{0,1});
        // list.add(new int[]{1,3});
        // list.add(new int[]{2,0});

        //System.out.println(helper(list,3,2));
        posns(N, N, 0, 0, list, fin);
        for(ArrayList<ArrayList<String>> ele: fin){
            for(ArrayList<String> list1 : ele){
                for(String s:list1){
                    System.out.print(s+" ");
                }
                System.out.println(); 
            }
            System.out.println(); 
            
        }
    }
}
