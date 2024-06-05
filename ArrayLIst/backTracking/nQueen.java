package backTracking;

public class nQueen {
    public static boolean isSafe(char queenGrid[][],int row,int col){
        // cheking for col in upper direction
        for(int i=row-1;i>=0;i--){
                 if(queenGrid[i][col]=='Q'){
                    return false;
                 }
        }

        // cheking for upper left diagonal
        for(int i=row-1,j=col-1;i>=0&& j>=0;i--,j--){
              if(queenGrid[i][j]=='Q'){
                return false;
              }
        }
        // checking for upper right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<queenGrid.length;i--,j++){// mitakenly written j<col in conditional
            if(queenGrid[i][j]=='Q'){
                return false;
              }
        }
        return true; 
    }

    //placing queen in each row recursively: 
    public static void placeQueens(char queenGrid[][],int row){
                 // base case 
                 if(row>=queenGrid.length){
                 
                    printQueen(queenGrid);
                    count++;
                    return ;
                 }

                 //   kaam aur recursive call 
                 // for one row we need to fill queen in each column so use for loop till col size
                 for(int col=0;col<queenGrid.length;col++){
                    // check for each position is it is safe to put queen
                    if(isSafe(queenGrid,row,col)){
                        // place queen 
                        queenGrid[row][col]='Q';
                        // call for next row : because recursion completes the left hand first so it will go for next row for sure
                        placeQueens(queenGrid, row+1);
                        // remove queen while coming backing :  char[][] is mutable so we need to remove manually unlike string which is immutable
                        queenGrid[row][col]='X';
                    }
                 }

    }

    public static void printQueen(char queenGrid[][]){
        System.out.println("------------nQueen-----------");
        for(int i=0;i<queenGrid.length;i++){
            for(int j=0;j<queenGrid.length;j++){
                System.out.print(queenGrid[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int count=0;// static varialbes are declared outside main
    public static void main(String[] args) {
      
        int size=4;
        char queenGrid[][]=new char[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                queenGrid[i][j]='X';
            }
        }
        int row=0;
        placeQueens(queenGrid,row);
        System.out.println("Total no of solution to nQueen is: "+count);
    }
}
