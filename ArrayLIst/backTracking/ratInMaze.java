package backTracking;
public class ratInMaze{
   
    public static boolean isSafe(int row, int col, int i, int j, int visited[][], int ratPos[][]) {
        if((i >= 0 && i < row )&& (j >= 0 && j < col) &&(visited[i][j] == 0) &&(ratPos[i][j] == 1)){
            return true;
        }
       else {
        return false;
       }
    }
    
    public static void solveMaze(int ratPos[][], int row, int col, int i, int j, int visited[][], StringBuilder output) {
        if (i == row - 1 && j == col - 1) {
            System.out.println(output);
            System.out.println();
            return;
        }
    
        // Mark the current cell as visited
        
    
        // Up
        if (isSafe(row, col, i - 1, j, visited, ratPos)) {
            // Mark the current cell as visited
            visited[i - 1][j] = 1;
            solveMaze(ratPos, row, col, i - 1, j, visited, output.append("U") );
            visited[i - 1][j] = 0;  // Backtrack
            output.deleteCharAt(output.length() - 1);
        }
    
        // Down
        if (isSafe(row, col, i + 1, j, visited, ratPos)) {
            // Mark the current cell as visited
            visited[i + 1][j] = 1;
            solveMaze(ratPos, row, col, i + 1, j, visited, output.append("D") );
            visited[i + 1][j] = 0;  // Backtrack
            output.deleteCharAt(output.length() - 1);
        }
    
        // Left
        if (isSafe(row, col, i, j - 1, visited, ratPos)) {
            // Mark the current cell as visited
            visited[i][j - 1] = 1;
            solveMaze(ratPos, row, col, i, j - 1, visited, output.append("L") );
            visited[i][j - 1] = 0;  // Backtrack
            output.deleteCharAt(output.length() - 1);
        }
    
        // Right
        if (isSafe(row, col, i, j + 1, visited, ratPos)) {
            // Mark the current cell as visited
            visited[i][j + 1] = 1;
            solveMaze(ratPos, row, col, i, j + 1, visited, output.append("R") );
            visited[i][j + 1] = 0;  // Backtrack
            output.deleteCharAt(output.length() - 1);
        }
    
      
    }
    
    public static void main(String[] args) {
        

        int ratPos[][]={{1,0,0},{1,1,0},{1,1,1}};
        int marking[][]={{1,0,0},{0,0,0},{0,0,0}};
        // use collection string as we do not know how many solutoins can be there
        int col=3,row=3;
        int i=0,j=0;
        StringBuilder ans=new StringBuilder("");
       solveMaze(ratPos,row,col ,i,j,marking,ans);
    }
}
