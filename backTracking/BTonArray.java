package backTracking;

public class BTonArray {
    public static void solve(int arr[],int index){
        // base case
        if(index>=arr.length){
            printArray(arr);
            return ;
        }
        // kaam
        arr[index]=index+1;
        solve(arr,index+1);
        arr[index]-=2;
    }
    public static void printArray(int arr[]){
        for(int num:arr){
            System.out.print(num+" ");
         }
         System.out.println();
    }
    public static void main(String[] args) {
        int arr[]=new int[5];
         solve(arr,0);
        printArray(arr);
    }
}
