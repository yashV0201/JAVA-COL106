public class sudokuSolver {
    static boolean checker(char[][] board,int i, int j, char n){
        
        for(int row =  0; row<board.length; row ++){
             if(board[i][row]==n || board[row][j]==n) return false;
        }
        int row = (i/3)*3;
        int col = (j/3)*3;
        for(int k = row; k<row+3;k++){
            for(int l = col; l<col+3; l++){
                if(board[k][l] == n) return false;
            }
        }

        return true;
    }

    static void solver(char[][] board, int row, int col){
        if(row == 9){
            for(int i = 0; i<9; i++){
                for(int j=0; j<9;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        else if(col == 9){
            solver(board, row+1, 0);
            return;
        }

        if(board[row][col]=='.'){
            for(int k =1; k<=9;k++){
                if(checker(board, row, col,(char)('0'+k))){
                    board[row][col] = (char)('0'+k);
                    solver(board, row, col+1);
                    board[row][col] = '.';
                }
            }
           
        }
        else solver(board, row, col+1);
       
    }

    public static void main(String[] args) {
        char[][] board= {
            {'8' , '2' , '.' , '5' , '.' , '1' , '.' , '7' , '.'},
            {'7' , '.' , '.' , '.' , '.' , '.' , '4' , '.' , '.'},
            {'.' , '.' , '.' , '.' , '.' , '6' , '.' , '.' , '.'},
            {'.' , '.' , '3' , '.' , '.' , '.' , '.' , '.' , '9'},
            {'.' , '.' , '.' , '.' , '8' , '.' , '.' , '.' , '.'},
            {'.' , '1' , '.' , '2' , '.' , '7' , '.' , '4' , '.'},
            {'.' , '.' , '.' , '.' , '6' , '.' , '.' , '5' , '.'},
            {'.' , '8' , '.' , '.' , '4' , '.' , '.' , '.' , '.'},
            {'.' , '.' , '1' , '8' , '.' , '5' , '3' , '.' , '.'}
        };

        solver(board, 0, 0); 

        
    }
}
