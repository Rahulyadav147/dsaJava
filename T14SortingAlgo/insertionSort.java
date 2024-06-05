package T14SortingAlgo;

public class insertionSort {
    public static void InsertionSort(int arr[]){
         // run loop n-1 times because last element will be automaticaly sorted
        //also start the loop from 1 because we have taken loop works on the condition when it is greater 0
        
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int temp=arr[i];
            //finding out correct position to insert
            while(j>=0&&(arr[j]>temp)){// do not do arr[j]>arr[i]: because arr[i] is replaced with previous value
                arr[j+1]=arr[j];
                j--;
            }
             //insertion
            arr[j+1]=temp;
        }
    }
    public static void main(String[] args){
int arr[]={4,1,6,3,8,2};
        InsertionSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
