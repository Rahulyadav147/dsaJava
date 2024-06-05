package backTracking;

public class sudokuSolver {
    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        // for row
         for(int i=0;i<9;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
         }


        // for col

        for(int i=0;i<9;i++){
            if(sudoku[row][i]==digit){
                return false;
            }
         }

        // for grid 3*3
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean sudoku_solver(int sudoku[][],int row,int col){
        // base case 
        if(row==9){
            // it means we have traversed entire grid
            return true;
        }


        // kaam and recursion 
        int nextRow=row,nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }
        // if there is some digit at that position already move to next pos
        if(sudoku[row][col]!=0){
             return  sudoku_solver(sudoku,nextRow,nextCol);
        }
        // place digit from 1 to 9 in each row and col
        for(int digit=1;digit<=9;digit++){
            // if safe place it
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                // call for next place
                if(sudoku_solver(sudoku,nextRow,nextCol)){ // if solution exists return it
                    return true;
                }
              
               // backtracking 
               sudoku[row][col]=0;
            }
          


        }
        // if there is no solution at all
        return false;

    }

    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<sudoku.length;i++){
            for(int j=0;j<sudoku.length;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudoku [][] = { 
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
            };
        int startRow=0,startCol=0;
        if(sudoku_solver(sudoku,startRow,startCol)){
            printSudoku(sudoku);
            System.out.println("Solution Exists.");
        }
        else{
            System.out.println("Solution does not exist.");
        }
    }
}
