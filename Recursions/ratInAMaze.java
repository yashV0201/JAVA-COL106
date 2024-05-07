import java.util.ArrayList;
import java.util.List;

public class ratInAMaze {
    
    static void move(int[][] maze, int x, int y, String s, List<String> ans){
        if(x==maze.length-1 && y==maze.length-1){
            //System.out.print(s+" ");
            ans.add(s);
            return;
        }

        //moving down
        if((x+1 != maze.length) && maze[x+1][y] == 1){
            maze[x][y] = -1;  //marking the travelled path
            move(maze, x+1, y, s+'D', ans);
        }
        
        //moving right
        if((y+1 != maze.length)&& maze[x][y+1] == 1){
            maze[x][y] = -1;
            move(maze, x, y+1, s+'R', ans);
        }
        //moving left
        if((y>0)&& maze[x][y-1] == 1){
            maze[x][y] = -1;
            move(maze, x, y-1, s+'L', ans);
        }
        //moving up
        if((x>0)&& maze[x-1][y] == 1){
            maze[x][y] = -1;
            move(maze, x-1, y, s+'U', ans);
        }

        maze[x][y] =1 ;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1,1,1,1,1},
            {0,0,0,0,1},
            {1,1,1,1,1},
            {1,0,0,0,0},
            {1,1,1,1,1}
        };
        List<String> ans = new ArrayList<>();
        move(maze, 0, 0, "", ans);
        System.out.println(ans.toString());
    }
}
