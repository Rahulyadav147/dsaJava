package backTracking;

public class gridWays {

    public static int grid_ways(int m,int n,int row,int col){
        // base case 
        if(row==m-1&&col==n-1){// last cell condition
            return 1;
        }
        else if(row==m|| col==n){// boundry cross condition
            return 0;
        }
        // kaam
        // down jane ke liye
        int ans1=grid_ways(m, n, row+1, col);
        // right jane ke liye
        int ans2=grid_ways(m, n, row, col+1);
        return ans1+ans2;
    }
    public static void main(String[] args) {
        int m=3,n=3;
        int startRow=0,startCol=0;
        System.out.println("Total no of ways is:"+grid_ways(m,n,startRow,startCol));
    }
}
