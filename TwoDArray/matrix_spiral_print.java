package TwoDArray;

public class matrix_spiral_print{

    public static void spiralPrint(int matrix [][]){
      int startRow = 0;
      int startCol = 0;
      int endRow =   matrix.length-1;
      int endCol = matrix[0].length-1;

      while(startRow <= endRow && startCol <= endCol ){

        //printing top part
        for(int i = startCol; i <= endCol;i++){
            System.out.print(matrix[startRow][i]+" ");
        }

        // printint right side part
        for(int i =startRow+1; i<=endRow; i++){
            System.out.print(matrix[i][endCol]+" ");
        }

        // printing bottom part
        for(int i = endCol-1; i >= startCol; i--){
            if(startCol == endCol){
                break;
           }
            System.out.print(matrix[endCol][i]+" ");
        }

        // printing left side part
        for(int i = endRow-1; i>= startRow+1; i--){
            if(startRow == endRow){
                 break;
            }
            System.out.print(matrix[i][startCol]+" ");
        }

        startRow++;
        startCol++;
        endRow--;
        endCol--;

        System.out.println();
      }

    }
    

    public static void main(String args[]){

        int matrix [][] = { 
            {1,2,3},
            {8,9,4},
            {7,6,5}
            };    
        
        spiralPrint(matrix);
    }
    
}
