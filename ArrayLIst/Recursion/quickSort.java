package Recursion;

public class quickSort {
   public static int findIndex(int arr[],int low,int high){
    int i=low,j= high;
    int pivot=arr[low];
    while(i<j){
        //moving forward elements are smaller or equal than pivot 
        while(arr[i]<=pivot&& i<=high-1){i++;}// high-1 because in next iteration arr[i]=arr[high] else arr[i]=arr[high+1] i.e overflow
        // moving backward if elements are greater than pivot 
        while(arr[j]>pivot&&j>=low+1){j--;}// low +1 because in next iteration arr[j]=arr[low] if not arr[j]=arr[low-1]
        // if i < j so we need to swap the elements to bring smaller to left and larger to right (no pivot in picture till now)
        if(i<j){// swapping to be done in i and j indexes 
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }


    }
    // in last when j crossed i swap pivot and j and return j;
    int temp=arr[j];
            arr[j]=arr[low];
            arr[low]=temp;
    return j;
    }

    public static void quicksort(int arr[],int low,int high){
            if(low<high){// base case
               
            
            int partitionIndex=findIndex(arr,low,high);
            quicksort(arr,low,partitionIndex-1);
            quicksort(arr,partitionIndex+1,high);
            }
            

    }
    public static void main(String[] args) {
        int arr[]={1,4,2,9,3,9,4,8,5};
        quicksort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        } 
    }
}
