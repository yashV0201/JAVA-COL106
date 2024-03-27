import java.util.ArrayList;
import java.util.List;

public class N_Queens_sol {

    static List<String> construct(char[][] board){
        List<String> res = new ArrayList<String>();
        for(int i = 0; i<board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }

        return res;
    }


    static void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal){
        if(col == board.length){
            res.add(construct(board));
            return;
        }

        for(int row =0; row<board.length;row++){
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[board.length-1+col-row] == 0){
                leftRow[row] =1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[board.length-1+col-row] = 1;
                board[row][col] = 'Q';
                solve(col+1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[board.length-1+col-row] = 0;
                board[row][col] = '.';
            }
        }
    }

    static List<List<String>> queens(int n){
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j] = '.';
            }
        }
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2*n -1];
        int[] upperDiagonal = new int[2*n -1];

        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);

        return res;

    }

    public static void main(String[] args) {
        int n = 5;
        List<List<String>> res = queens(n);
        for(List<String> ele : res){
            for(String s:ele){
                for(int i =0; i<n;i++){
                    System.out.print(s.charAt(i)+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
